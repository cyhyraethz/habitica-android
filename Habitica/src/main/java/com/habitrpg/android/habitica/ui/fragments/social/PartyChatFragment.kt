package xyz.prfn.android.habitica.ui.fragments.social

import androidx.fragment.app.viewModels
import xyz.prfn.android.habitica.ui.viewmodels.PartyViewModel

class PartyChatFragment : ChatFragment() {
    override val viewModel: PartyViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )
}
