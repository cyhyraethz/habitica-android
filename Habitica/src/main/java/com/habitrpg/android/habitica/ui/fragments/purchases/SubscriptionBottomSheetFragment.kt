package xyz.prfn.android.habitica.ui.fragments.purchases

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.android.billingclient.api.ProductDetails
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.data.InventoryRepository
import xyz.prfn.android.habitica.data.UserRepository
import xyz.prfn.android.habitica.databinding.FragmentBottomsheetSubscriptionBinding
import xyz.prfn.android.habitica.helpers.AppConfigManager
import xyz.prfn.android.habitica.helpers.PurchaseHandler
import xyz.prfn.android.habitica.helpers.PurchaseTypes
import xyz.prfn.android.habitica.models.user.User
import xyz.prfn.android.habitica.ui.views.subscriptions.SubscriptionOptionView
import com.habitrpg.common.habitica.helpers.ExceptionHandler
import com.habitrpg.common.habitica.helpers.MainNavigationController
import com.habitrpg.common.habitica.helpers.launchCatching
import com.habitrpg.common.habitica.helpers.setMarkdown
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
open class SubscriptionBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomsheetSubscriptionBinding? = null
    val binding get() = _binding!!

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var appConfigManager: AppConfigManager

    @Inject
    lateinit var inventoryRepository: InventoryRepository

    @Inject
    lateinit var purchaseHandler: PurchaseHandler

    private var selectedSubscriptionSku: ProductDetails? = null
    internal var skus: List<ProductDetails> = emptyList()

    private var user: User? = null
    private var hasLoadedSubscriptionOptions: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomsheetSubscriptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.content.subscriptionOptions.visibility = View.GONE
        binding.content.subscribeButton.setOnClickListener { purchaseSubscription() }
        binding.content.subscriptionDisclaimerView.setMarkdown("Once we’ve confirmed your purchase, the payment will be charged to your Google Account.\n\nSubscriptions automatically renew unless auto-renewal is turned off at least 24-hours before the end of the current period. If you have an active subscription, your account will be charged for renewal within 24-hours prior to the end of your current subscription period and you will be charged the same price you initially paid.\n\nBy continuing you accept the [Terms of Use](https://habitica.com/static/terms) and [Privacy Policy](https://habitica.com/static/privacy).")

        lifecycleScope.launchCatching {
            userRepository.getUser().collect { user ->
                user?.let { setUser(it) }
            }
        }

        binding.content.subscriptionDetails.visibility = View.GONE
        binding.content.subscribeBenefitsFooter.visibility = View.GONE
        binding.content.giftSegmentSubscribed.root.visibility = View.GONE
        binding.content.giftSegmentUnsubscribed.root.visibility = View.GONE
        binding.content.headerImageView.visibility = View.GONE
        binding.content.subscriptionDisclaimerView.visibility = View.VISIBLE
        binding.content.seeMoreButton.visibility = View.VISIBLE

        binding.content.seeMoreButton.setOnClickListener {
            MainNavigationController.navigate(
                R.id.gemPurchaseActivity,
                bundleOf(Pair("openSubscription", true))
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener { dialog: DialogInterface ->
            val notificationDialog = dialog as BottomSheetDialog
            notificationDialog.behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            notificationDialog.behavior.isDraggable = true
        }
        return bottomSheetDialog
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launchCatching {
            purchaseHandler.queryPurchases()
        }
        refresh()
        loadInventory()
    }

    private fun refresh() {
        lifecycleScope.launch(ExceptionHandler.coroutine()) {
            userRepository.retrieveUser(false, true)
        }
    }

    private fun loadInventory() {
        CoroutineScope(Dispatchers.IO).launchCatching {
            val subscriptions = purchaseHandler.getAllSubscriptionProducts()
            skus = subscriptions
            withContext(Dispatchers.Main) {
                for (sku in subscriptions) {
                    updateButtonLabel(
                        sku,
                        sku.subscriptionOfferDetails?.firstOrNull()?.pricingPhases?.pricingPhaseList?.firstOrNull()?.formattedPrice
                            ?: ""
                    )
                }
                if (selectedSubscriptionSku == null) {
                    subscriptions
                        .filter { buttonForSku(it)?.isVisible == true }
                        .maxByOrNull {
                            it.subscriptionOfferDetails?.firstOrNull()?.pricingPhases?.pricingPhaseList?.firstOrNull()?.priceAmountMicros
                                ?: 0
                        }?.let { selectSubscription(it) }
                }
                hasLoadedSubscriptionOptions = true
                updateSubscriptionInfo()
            }
        }
    }

    private fun updateButtonLabel(
        sku: ProductDetails,
        price: String
    ) {
        val matchingView = buttonForSku(sku)
        if (matchingView != null) {
            matchingView.setPriceText(price)
            matchingView.sku = sku.productId
            matchingView.setOnPurchaseClickListener {
                selectSubscription(sku)
            }
        }
    }

    internal fun selectSubscription(sku: ProductDetails) {
        if (this.selectedSubscriptionSku != null) {
            val oldButton = buttonForSku(this.selectedSubscriptionSku)
            oldButton?.setIsSelected(false)
        }
        this.selectedSubscriptionSku = sku
        val subscriptionOptionButton = buttonForSku(this.selectedSubscriptionSku)
        subscriptionOptionButton?.setIsSelected(true)
        binding.content.subscribeButton.isEnabled = true
    }

    internal fun buttonForSku(sku: ProductDetails?): SubscriptionOptionView? {
        return buttonForSku(sku?.productId)
    }

    private fun buttonForSku(sku: String?): SubscriptionOptionView? {
        return when (sku) {
            PurchaseTypes.SUBSCRIPTION_1_MONTH -> binding.content.subscription1month
            PurchaseTypes.SUBSCRIPTION_3_MONTH -> binding.content.subscription3month
            PurchaseTypes.SUBSCRIPTION_12_MONTH -> binding.content.subscription12month
            else -> null
        }
    }

    private fun purchaseSubscription() {
        selectedSubscriptionSku?.let { sku ->
            activity?.let {
                purchaseHandler.purchase(it, sku)
                dismiss()
            }
        }
    }

    fun setUser(newUser: User) {
        user = newUser
        this.updateSubscriptionInfo()
        checkIfNeedsCancellation()
    }

    private fun updateSubscriptionInfo() {
        if (hasLoadedSubscriptionOptions) {
            binding.content.subscriptionOptions.visibility = View.VISIBLE
            binding.content.loadingIndicator.visibility = View.GONE
        }
        if (user != null) {
            binding.content.loadingIndicator.visibility = View.GONE
            binding.content.subscription12month.showHourglassPromo(user?.purchased?.plan?.isEligableForHourglassPromo == true)
            val totalGemCap = user?.purchased?.plan?.totalNumberOfGemsAlways ?: 24
            binding.content.subscription1month.gemCap = totalGemCap
            binding.content.subscription3month.gemCap = totalGemCap
            binding.content.subscription6month.gemCap = totalGemCap

            if (totalGemCap > 24) {
                binding.content.existingGemCapBonusView.visibility = View.VISIBLE
                binding.content.gemCapExtraLabel.text = getString(R.string.gem_cap_extra, totalGemCap, 50)
                binding.content.extraGemsProgress.progress = totalGemCap
            } else {
                binding.content.existingGemCapBonusView.visibility = View.GONE
            }
        }
    }

    private fun checkIfNeedsCancellation() {
        CoroutineScope(Dispatchers.IO).launch(ExceptionHandler.coroutine()) {
            val newestSubscription = purchaseHandler.checkForSubscription()
            if (user?.purchased?.plan?.paymentMethod == "Google" &&
                user?.purchased?.plan?.isActive == true &&
                user?.purchased?.plan?.dateTerminated == null &&
                (newestSubscription?.isAutoRenewing != true)
            ) {
                lifecycleScope.launch(ExceptionHandler.coroutine()) {
                    purchaseHandler.cancelSubscription()
                }
            }
        }
    }

    companion object {
        const val TAG = "SubscriptionBottomSheet"
    }
}
