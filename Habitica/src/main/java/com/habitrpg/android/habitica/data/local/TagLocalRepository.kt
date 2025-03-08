package xyz.prfn.android.habitica.data.local

import xyz.prfn.android.habitica.models.Tag
import kotlinx.coroutines.flow.Flow

interface TagLocalRepository : BaseLocalRepository {
    fun getTags(userId: String): Flow<List<Tag>>

    fun deleteTag(tagID: String)
}
