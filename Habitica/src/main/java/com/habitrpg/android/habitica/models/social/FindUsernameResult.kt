package xyz.prfn.android.habitica.models.social

import com.google.gson.annotations.SerializedName
import xyz.prfn.android.habitica.models.user.Authentication
import xyz.prfn.android.habitica.models.user.ContributorInfo
import xyz.prfn.android.habitica.models.user.Profile

class FindUsernameResult {
    @SerializedName("_id")
    var id: String? = null

    var contributor: ContributorInfo? = null
    var authentication: Authentication? = null
    var profile: Profile? = null

    val username: String?
        get() = authentication?.localAuthentication?.username
    val formattedUsername: String?
        get() = if (username != null) "@$username" else null

    override fun toString(): String {
        return "@${authentication?.localAuthentication?.username ?: ""}"
    }
}
