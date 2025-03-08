package xyz.prfn.android.habitica.ui.views.insufficientCurrency

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.extensions.addCloseButton
import xyz.prfn.android.habitica.ui.views.HabiticaIconsHelper
import com.habitrpg.common.habitica.helpers.MainNavigationController

class InsufficientHourglassesDialog(context: Context) : InsufficientCurrencyDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageView.setImageBitmap(HabiticaIconsHelper.imageOfHourglassShop())
        textView.setText(R.string.insufficientHourglasses)

        addButton(
            R.string.get_hourglasses,
            true
        ) { _, _ ->
            MainNavigationController.navigate(
                R.id.gemPurchaseActivity,
                bundleOf(Pair("openSubscription", true))
            )
        }
        addCloseButton()
    }
}
