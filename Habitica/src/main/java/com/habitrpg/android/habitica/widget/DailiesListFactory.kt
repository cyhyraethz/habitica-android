package xyz.prfn.android.habitica.widget

import android.content.Context
import android.content.Intent
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.data.TaskRepository
import xyz.prfn.android.habitica.data.UserRepository
import com.habitrpg.shared.habitica.models.tasks.TaskType

class DailiesListFactory(
    context: Context,
    intent: Intent,
    taskRepository: TaskRepository,
    userRepository: UserRepository
) : TaskListFactory(
    context,
    intent,
    TaskType.DAILY,
    R.layout.widget_dailies_list_row,
    R.id.dailies_text,
    taskRepository,
    userRepository
)
