package xyz.prfn.android.habitica.data.implementation

import xyz.prfn.android.habitica.data.ApiClient
import xyz.prfn.android.habitica.data.TutorialRepository
import xyz.prfn.android.habitica.data.local.TutorialLocalRepository
import xyz.prfn.android.habitica.models.TutorialStep
import xyz.prfn.android.habitica.modules.AuthenticationHandler
import kotlinx.coroutines.flow.Flow

class TutorialRepositoryImpl(
    localRepository: TutorialLocalRepository,
    apiClient: ApiClient,
    authenticationHandler: AuthenticationHandler
) : BaseRepositoryImpl<TutorialLocalRepository>(localRepository, apiClient, authenticationHandler),
    TutorialRepository {
    override fun getTutorialStep(key: String): Flow<TutorialStep> =
        localRepository.getTutorialStep(key)

    override fun getTutorialSteps(keys: List<String>): Flow<List<TutorialStep>> =
        localRepository.getTutorialSteps(keys)
}
