package xyz.prfn.android.habitica.models.social

import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class ChatMessageLike(var id: String = "") : RealmObject(), BaseObject
