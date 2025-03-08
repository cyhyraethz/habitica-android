package xyz.prfn.android.habitica.ui.views.dialogs

import android.content.Context
import xyz.prfn.android.habitica.extensions.addCloseButton
import xyz.prfn.android.habitica.models.inventory.QuestContent
import xyz.prfn.android.habitica.ui.views.shops.PurchaseDialogQuestContent

class DetailDialog(context: Context) : HabiticaAlertDialog(context) {
    var quest: QuestContent? = null
        set(value) {
            field = value
            if (value == null) return

            val contentView = PurchaseDialogQuestContent(context)
            contentView.setQuestContentItem(value)
            setAdditionalContentView(contentView)
        }

    init {
        addCloseButton()
    }
}
