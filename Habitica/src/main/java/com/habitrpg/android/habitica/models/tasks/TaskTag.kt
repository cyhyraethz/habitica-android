package xyz.prfn.android.habitica.models.tasks

import xyz.prfn.android.habitica.models.BaseObject
import xyz.prfn.android.habitica.models.Tag
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class TaskTag : RealmObject(), BaseObject {
    var tag: Tag? = null
    var task: Task? = null
}
