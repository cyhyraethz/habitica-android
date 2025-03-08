package xyz.prfn.android.habitica.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass(embedded = true)
open class WorldStateEvent : RealmObject(), BaseMainObject {
    val isCurrentlyActive: Boolean
        get() {
            val now = Date()
            return (start?.before(now) == true) && (end?.after(now) == true)
        }

    @SerializedName("event")
    var eventKey: String? = null
    var start: Date? = null
    var end: Date? = null
    var promo: String? = null
    var season: String? = null
    var npcImageSuffix: String? = null
    var aprilFools: String? = null
    var gear: Boolean = false

    override val realmClass: Class<out RealmModel>
        get() = WorldStateEvent::class.java
    override val primaryIdentifier: String?
        get() = eventKey
    override val primaryIdentifierName: String
        get() = "eventKey"
}
