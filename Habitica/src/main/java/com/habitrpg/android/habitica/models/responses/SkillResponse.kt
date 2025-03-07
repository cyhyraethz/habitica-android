package xyz.prfn.android.habitica.models.responses

import xyz.prfn.android.habitica.models.tasks.Task
import xyz.prfn.android.habitica.models.user.User

class SkillResponse {
    var user: User? = null
    var task: Task? = null
    var expDiff = 0.0
    var hpDiff = 0.0
    var goldDiff = 0.0
    var damage = 0.0f
}
