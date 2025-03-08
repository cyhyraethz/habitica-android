package xyz.prfn.android.habitica.data.local

import xyz.prfn.android.habitica.models.inventory.Customization
import kotlinx.coroutines.flow.Flow

interface CustomizationLocalRepository : ContentLocalRepository {
    fun getCustomizations(
        type: String,
        category: String?,
        onlyAvailable: Boolean
    ): Flow<List<Customization>>
}
