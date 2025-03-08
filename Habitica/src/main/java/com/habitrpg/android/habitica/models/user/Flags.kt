package xyz.prfn.android.habitica.models.user

import xyz.prfn.android.habitica.models.BaseObject
import xyz.prfn.android.habitica.models.TutorialStep
import com.habitrpg.shared.habitica.models.AvatarFlags
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class Flags : RealmObject(), BaseObject, AvatarFlags {
    var tutorial: RealmList<TutorialStep>? = null
    var showTour = false
    var dropsEnabled = false
    var itemsEnabled = false
    var newStuff = false
    var lastNewStuffRead: String? = null
    override var classSelected = false
    var rebirthEnabled = false
    var welcomed = false
    var armoireEnabled = false
    var armoireOpened = false
    var armoireEmpty = false
    var communityGuidelinesAccepted = false
    var verifiedUsername = false
    var isWarnedLowHealth = false
}
