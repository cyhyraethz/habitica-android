package xyz.prfn.android.habitica.interactors

import xyz.prfn.android.habitica.data.TaskRepository
import xyz.prfn.android.habitica.helpers.SoundManager
import xyz.prfn.android.habitica.models.tasks.Task
import xyz.prfn.android.habitica.models.user.User
import com.habitrpg.shared.habitica.models.responses.TaskScoringResult
import javax.inject.Inject

class BuyRewardUseCase
@Inject
constructor(
    private val taskRepository: TaskRepository,
    private val soundManager: SoundManager
) : UseCase<BuyRewardUseCase.RequestValues, TaskScoringResult?>() {
    override suspend fun run(requestValues: RequestValues): TaskScoringResult? {
        val response =
            taskRepository.taskChecked(
                requestValues.user,
                requestValues.task,
                false,
                false,
                requestValues.notifyFunc
            )
        soundManager.loadAndPlayAudio(SoundManager.SOUND_REWARD)
        return response
    }

    class RequestValues(
        internal val user: User?,
        val task: Task,
        val notifyFunc: (TaskScoringResult) -> Unit
    ) : UseCase.RequestValues
}
