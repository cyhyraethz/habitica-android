package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class UserAchievement() : RealmObject(), BaseObject {
    var key: String? = null
    var earned: Boolean = false

    constructor(key: String, earned: Boolean) : this() {
        this.key = key
        this.earned = earned
    }
}
