package xyz.prfn.android.habitica.data

import xyz.prfn.android.habitica.models.TutorialStep
import kotlinx.coroutines.flow.Flow

interface TutorialRepository : BaseRepository {
    fun getTutorialStep(key: String): Flow<TutorialStep>

    fun getTutorialSteps(keys: List<String>): Flow<out List<TutorialStep>>
}
