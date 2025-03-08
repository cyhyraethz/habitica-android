package xyz.prfn.android.habitica.models.social

import com.google.gson.annotations.SerializedName
import xyz.prfn.android.habitica.models.BaseMainObject
import xyz.prfn.android.habitica.models.inventory.Quest
import xyz.prfn.android.habitica.models.user.SubscriptionPlan
import com.habitrpg.shared.habitica.models.tasks.TasksOrder
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey

open class Group : RealmObject(), BaseMainObject {
    val isGroupPlan: Boolean
        get() {
            return purchased?.isActive == true
        }
    override val realmClass: Class<Group>
        get() = Group::class.java
    override val primaryIdentifier: String?
        get() = id
    override val primaryIdentifierName: String
        get() = "id"

    @SerializedName("_id")
    @PrimaryKey
    var id: String = ""
    var balance: Double = 0.toDouble()
    var description: String? = null
    var summary: String? = null
    var leaderID: String? = null
    var leaderName: String? = null
    var managers: RealmList<String>? = null
    var name: String? = null
    var memberCount: Int = 0
    var type: String? = null
    var logo: String? = null
    var quest: Quest? = null
    var privacy: String? = null
    var challengeCount: Int = 0
    var leaderMessage: String? = null
    var leaderOnlyChallenges: Boolean = false
    var leaderOnlyGetGems: Boolean = false
    var categories: RealmList<GroupCategory>? = null
    var purchased: SubscriptionPlan? = null

    @Ignore
    var tasksOrder: TasksOrder? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        val group = other as? Group
        return id == group?.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    fun hasTaskEditPrivileges(userID: String): Boolean {
        if (isLeader(userID)) {
            return true
        }
        return isManager(userID)
    }

    fun canManageManagers(userID: String): Boolean {
        return isLeader(userID)
    }

    fun isLeader(userID: String): Boolean = leaderID == userID

    fun isManager(userID: String): Boolean = managers?.contains(userID) == true

    companion object {
        const val TAVERN_ID = "00000000-0000-4000-A000-000000000000"
    }

    val hasActiveQuest: Boolean
        get() {
            return quest?.active ?: false
        }

    val gemCount: Int
        get() {
            return (balance * 4.0).toInt()
        }
}
