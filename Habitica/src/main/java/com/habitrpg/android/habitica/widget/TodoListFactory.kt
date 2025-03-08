package xyz.prfn.android.habitica.widget

import android.content.Context
import android.content.Intent
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.data.TaskRepository
import xyz.prfn.android.habitica.data.UserRepository
import com.habitrpg.shared.habitica.models.tasks.TaskType

class TodoListFactory(
    context: Context,
    intent: Intent,
    taskRepository: TaskRepository,
    userRepository: UserRepository
) : TaskListFactory(
    context,
    intent,
    TaskType.TODO,
    R.layout.widget_todo_list_row,
    R.id.todo_text,
    taskRepository,
    userRepository
)
