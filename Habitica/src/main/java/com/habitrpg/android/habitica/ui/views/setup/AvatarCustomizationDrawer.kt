package xyz.prfn.android.habitica.ui.views.setup

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import xyz.prfn.android.habitica.databinding.AvatarSetupDrawerBinding
import com.habitrpg.common.habitica.extensions.layoutInflater

class AvatarCustomizationDrawer(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {
    val binding = AvatarSetupDrawerBinding.inflate(context.layoutInflater, this, true)
}
