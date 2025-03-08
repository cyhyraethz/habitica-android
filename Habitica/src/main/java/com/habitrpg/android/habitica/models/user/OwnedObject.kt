package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject

interface OwnedObject : BaseObject {
    var userID: String?
    var key: String?
}
