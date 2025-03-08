package xyz.prfn.android.habitica.widget

import xyz.prfn.android.habitica.R

class DailiesWidgetProvider : TaskListWidgetProvider() {
    override val serviceClass: Class<*>
        get() = DailiesWidgetService::class.java
    override val providerClass: Class<*>
        get() = DailiesWidgetProvider::class.java
    override val titleResId: Int
        get() = R.string.dailies
}
