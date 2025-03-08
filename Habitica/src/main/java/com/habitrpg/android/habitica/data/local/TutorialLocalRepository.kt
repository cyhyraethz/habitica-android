package xyz.prfn.android.habitica.data.local

import xyz.prfn.android.habitica.models.TutorialStep
import kotlinx.coroutines.flow.Flow

interface TutorialLocalRepository : BaseLocalRepository {
    fun getTutorialStep(key: String): Flow<TutorialStep>

    fun getTutorialSteps(keys: List<String>): Flow<List<TutorialStep>>
}
