package xyz.prfn.android.habitica.data.implementation

import xyz.prfn.android.habitica.data.ApiClient
import xyz.prfn.android.habitica.data.FAQRepository
import xyz.prfn.android.habitica.data.local.FAQLocalRepository
import xyz.prfn.android.habitica.models.FAQArticle
import xyz.prfn.android.habitica.modules.AuthenticationHandler
import kotlinx.coroutines.flow.Flow

class FAQRepositoryImpl(
    localRepository: FAQLocalRepository,
    apiClient: ApiClient,
    authenticationHandler: AuthenticationHandler
) : BaseRepositoryImpl<FAQLocalRepository>(localRepository, apiClient, authenticationHandler),
    FAQRepository {
    override fun getArticle(position: Int): Flow<FAQArticle> {
        return localRepository.getArticle(position)
    }

    override fun getArticles(): Flow<List<FAQArticle>> {
        return localRepository.articles
    }
}
