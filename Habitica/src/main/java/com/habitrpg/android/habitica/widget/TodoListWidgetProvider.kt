package xyz.prfn.android.habitica.widget

import xyz.prfn.android.habitica.R

class TodoListWidgetProvider : TaskListWidgetProvider() {
    override val serviceClass: Class<*>
        get() = TodosWidgetService::class.java

    override val providerClass: Class<*>
        get() = TodoListWidgetProvider::class.java

    override val titleResId: Int
        get() = R.string.todos
}
