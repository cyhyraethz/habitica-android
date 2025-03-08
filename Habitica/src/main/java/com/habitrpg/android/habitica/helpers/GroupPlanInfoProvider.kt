package xyz.prfn.android.habitica.helpers

import android.content.res.Resources
import xyz.prfn.android.habitica.models.tasks.Task

interface GroupPlanInfoProvider {
    fun assignedTextForTask(
        resources: Resources,
        assignedUsers: List<String>
    ): String

    fun canScoreTask(task: Task): Boolean

    suspend fun canEditTask(task: Task): Boolean

    suspend fun canAddTasks(): Boolean
}
