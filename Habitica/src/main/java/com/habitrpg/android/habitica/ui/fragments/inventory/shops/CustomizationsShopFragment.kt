package xyz.prfn.android.habitica.ui.fragments.inventory.shops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.prfn.android.habitica.models.shops.Shop
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomizationsShopFragment : ShopFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shopIdentifier = Shop.CUSTOMIZATIONS
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
