package xyz.prfn.android.habitica.ui.views.dialogs

import android.content.Context
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.data.UserRepository
import xyz.prfn.android.habitica.models.inventory.QuestContent
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class QuestCompletedDialog(context: Context) : HabiticaAlertDialog(context) {
    lateinit var userRepository: UserRepository

    var quest: QuestContent? = null
        set(value) {
            field = value
            if (value == null) return

            val contentView = QuestCompletedDialogContent(context)
            contentView.setQuestContent(value)
            setAdditionalContentView(contentView)
        }

    override fun dismiss() {
        MainScope().launch {
            userRepository.syncUserStats()
        }
        isShowingDialog = false
        super.dismiss()
    }

    companion object {
        private var isShowingDialog = false

        fun showWithQuest(
            context: Context,
            quest: QuestContent,
            userRepository: UserRepository
        ) {
            if (isShowingDialog) return

            val dialog = QuestCompletedDialog(context)
            dialog.userRepository = userRepository
            dialog.quest = quest
            dialog.setTitle(R.string.quest_completed)
            dialog.addButton(R.string.onwards, isPrimary = true, isDestructive = false)
            dialog.enqueue()
            isShowingDialog = true
        }
    }
}
