package xyz.prfn.android.habitica.models.inventory

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class QuestRageStrike() : RealmObject(), BaseObject {
    @PrimaryKey
    var key = ""
    var wasHit = false

    constructor(key: String, wasHit: Boolean) : this() {
        this.key = key
        this.wasHit = wasHit
    }
}
