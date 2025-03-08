package xyz.prfn.android.habitica.ui.fragments.inventory.shops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.prfn.android.habitica.models.shops.Shop
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketFragment : ShopFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shopIdentifier = Shop.MARKET
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
