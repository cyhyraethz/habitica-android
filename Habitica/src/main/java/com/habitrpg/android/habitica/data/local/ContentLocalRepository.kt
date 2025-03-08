package xyz.prfn.android.habitica.data.local

import xyz.prfn.android.habitica.models.ContentResult
import xyz.prfn.android.habitica.models.WorldState
import kotlinx.coroutines.flow.Flow

interface ContentLocalRepository : BaseLocalRepository {
    fun saveContent(contentResult: ContentResult)

    fun saveWorldState(worldState: WorldState)

    fun getWorldState(): Flow<WorldState>
}
