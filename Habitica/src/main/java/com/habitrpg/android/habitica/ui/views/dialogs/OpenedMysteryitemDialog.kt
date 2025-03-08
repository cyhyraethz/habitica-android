package xyz.prfn.android.habitica.ui.views.dialogs

import android.content.Context
import xyz.prfn.android.habitica.databinding.DialogOpenMysteryitemBinding
import com.habitrpg.common.habitica.extensions.dpToPx
import com.habitrpg.common.habitica.extensions.layoutInflater

class OpenedMysteryitemDialog(context: Context) : HabiticaAlertDialog(context) {
    val binding = DialogOpenMysteryitemBinding.inflate(context.layoutInflater)

    init {
        setAdditionalContentView(binding.root)
        dialogWidth = 302.dpToPx(context)
    }
}
