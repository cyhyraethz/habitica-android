package xyz.prfn.android.habitica.data.local

import xyz.prfn.android.habitica.models.FAQArticle
import kotlinx.coroutines.flow.Flow

interface FAQLocalRepository : ContentLocalRepository {
    fun getArticle(position: Int): Flow<FAQArticle>

    val articles: Flow<List<FAQArticle>>
}
