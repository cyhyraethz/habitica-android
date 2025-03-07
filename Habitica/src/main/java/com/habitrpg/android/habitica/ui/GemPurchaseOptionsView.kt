package xyz.prfn.android.habitica.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.android.billingclient.api.ProductDetails
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.databinding.PurchaseGemViewBinding
import com.habitrpg.common.habitica.extensions.layoutInflater

class GemPurchaseOptionsView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {
    var binding: PurchaseGemViewBinding =
        PurchaseGemViewBinding.inflate(context.layoutInflater, this, true)
    var sku: ProductDetails? = null

    init {
        val a =
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.GemPurchaseOptionsView,
                0,
                0
            )

        binding.gemAmount.text = a.getText(R.styleable.GemPurchaseOptionsView_gemAmount)

        val iconRes = a.getDrawable(R.styleable.GemPurchaseOptionsView_gemDrawable)
        if (iconRes != null) {
            binding.gemImage.setImageDrawable(iconRes)
        }
    }

    fun setOnPurchaseClickListener(listener: OnClickListener) {
        binding.purchaseButton.setOnClickListener(listener)
    }

    fun setPurchaseButtonText(price: String) {
        binding.purchaseButton.text = price
    }
}
