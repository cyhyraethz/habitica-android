package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject
import xyz.prfn.android.habitica.models.inventory.Equipment
import com.habitrpg.shared.habitica.models.AvatarGear
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class Gear : RealmObject(), BaseObject, AvatarGear {
    var owned: RealmList<Equipment>? = null
    override var equipped: Outfit? = null
    override var costume: Outfit? = null
}
