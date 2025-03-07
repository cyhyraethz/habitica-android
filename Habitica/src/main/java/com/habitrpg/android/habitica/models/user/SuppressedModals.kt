package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class SuppressedModals : RealmObject(), BaseObject {
    var streak: Boolean? = null
    var raisePet: Boolean? = null
    var hatchPet: Boolean? = null
    var levelUp: Boolean? = null
}
