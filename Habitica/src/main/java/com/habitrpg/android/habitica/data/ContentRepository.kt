package xyz.prfn.android.habitica.data

import xyz.prfn.android.habitica.models.ContentResult
import xyz.prfn.android.habitica.models.WorldState
import kotlinx.coroutines.flow.Flow

interface ContentRepository : BaseRepository {
    suspend fun retrieveContent(forced: Boolean = false): ContentResult?

    suspend fun retrieveWorldState(forced: Boolean = false): WorldState?

    fun getWorldState(): Flow<WorldState>
}
