package xyz.prfn.android.habitica.models.inventory

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class QuestProgressCollect : RealmObject(), BaseObject {
    var key: String? = null
    var count = 0
}
