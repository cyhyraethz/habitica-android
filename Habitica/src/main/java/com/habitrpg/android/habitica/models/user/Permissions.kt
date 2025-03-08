package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject

open class Permissions : RealmObject(), BaseObject {
    var userSupport: Boolean = false
    var fullAccess: Boolean = false

    var moderator: Boolean = false
}
