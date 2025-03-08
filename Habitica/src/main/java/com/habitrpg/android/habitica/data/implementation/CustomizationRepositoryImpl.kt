package xyz.prfn.android.habitica.data.implementation

import xyz.prfn.android.habitica.data.ApiClient
import xyz.prfn.android.habitica.data.CustomizationRepository
import xyz.prfn.android.habitica.data.local.CustomizationLocalRepository
import xyz.prfn.android.habitica.models.inventory.Customization
import xyz.prfn.android.habitica.modules.AuthenticationHandler
import kotlinx.coroutines.flow.Flow

class CustomizationRepositoryImpl(
    localRepository: CustomizationLocalRepository,
    apiClient: ApiClient,
    authenticationHandler: AuthenticationHandler
) : BaseRepositoryImpl<CustomizationLocalRepository>(
    localRepository,
    apiClient,
    authenticationHandler
),
    CustomizationRepository {
    override fun getCustomizations(
        type: String,
        category: String?,
        onlyAvailable: Boolean
    ): Flow<List<Customization>> {
        return localRepository.getCustomizations(type, category, onlyAvailable)
    }
}
