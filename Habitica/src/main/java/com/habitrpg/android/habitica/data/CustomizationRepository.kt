package xyz.prfn.android.habitica.data

import xyz.prfn.android.habitica.models.inventory.Customization
import kotlinx.coroutines.flow.Flow

interface CustomizationRepository : BaseRepository {
    fun getCustomizations(
        type: String,
        category: String?,
        onlyAvailable: Boolean
    ): Flow<List<Customization>>
}
