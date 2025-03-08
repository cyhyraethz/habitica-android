package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class Backer : RealmObject(), BaseObject {
    var npc: String? = null
    var tier: Int? = null
}
