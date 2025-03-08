package xyz.prfn.android.habitica.ui.views.insufficientCurrency

import android.content.Context
import android.os.Bundle
import xyz.prfn.android.habitica.R

class InsufficientGoldDialog(context: Context) : InsufficientCurrencyDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageView.setImageResource(R.drawable.gold_multiple)
        textView.text = context.getString(R.string.insufficientGold)
        setTitle(R.string.insufficientGoldTitle)

        addButton(R.string.take_me_back, true)
    }
}
