package xyz.prfn.android.habitica.models.inventory

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class QuestMember : RealmObject(), BaseObject {
    @PrimaryKey
    var key: String? = null
    var isParticipating: Boolean? = null
}
