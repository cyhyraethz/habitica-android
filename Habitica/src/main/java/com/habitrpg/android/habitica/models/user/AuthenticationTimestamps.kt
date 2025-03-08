package xyz.prfn.android.habitica.models.user

import com.google.gson.annotations.SerializedName
import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass(embedded = true)
open class AuthenticationTimestamps : RealmObject(), BaseObject {
    @SerializedName("loggedin")
    var lastLoggedIn: Date? = null

    @SerializedName("created")
    var createdAt: Date? = null
}
