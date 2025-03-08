package xyz.prfn.android.habitica.data

import xyz.prfn.android.habitica.models.FAQArticle
import kotlinx.coroutines.flow.Flow

interface FAQRepository : BaseRepository {
    fun getArticles(): Flow<List<FAQArticle>>

    fun getArticle(position: Int): Flow<FAQArticle>
}
