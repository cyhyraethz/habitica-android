package xyz.prfn.android.habitica.data.local

import xyz.prfn.android.habitica.models.Achievement
import xyz.prfn.android.habitica.models.QuestAchievement
import xyz.prfn.android.habitica.models.Skill
import xyz.prfn.android.habitica.models.TeamPlan
import xyz.prfn.android.habitica.models.TutorialStep
import xyz.prfn.android.habitica.models.social.ChatMessage
import xyz.prfn.android.habitica.models.social.Group
import xyz.prfn.android.habitica.models.user.User
import xyz.prfn.android.habitica.models.user.UserQuestStatus
import io.realm.RealmResults
import kotlinx.coroutines.flow.Flow

interface UserLocalRepository : BaseLocalRepository {
    suspend fun getTutorialSteps(): Flow<RealmResults<TutorialStep>>

    fun getUser(userID: String): Flow<User?>

    fun saveUser(
        user: User,
        overrideExisting: Boolean = true
    )

    fun saveMessages(messages: List<ChatMessage>)

    fun getSkills(user: User): Flow<List<Skill>>

    fun getSpecialItems(user: User): Flow<List<Skill>>

    fun getAchievements(): Flow<List<Achievement>>

    fun getQuestAchievements(userID: String): Flow<List<QuestAchievement>>

    fun getUserQuestStatus(userID: String): Flow<UserQuestStatus>

    fun getTeamPlans(userID: String): Flow<List<TeamPlan>>

    fun getTeamPlan(teamID: String): Flow<Group?>
}
