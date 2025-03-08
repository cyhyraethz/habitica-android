package xyz.prfn.android.habitica.ui.adapter.social

import android.view.ViewGroup
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.models.members.Member
import xyz.prfn.android.habitica.ui.adapter.BaseRecyclerViewAdapter
import xyz.prfn.android.habitica.ui.viewHolders.GroupMemberViewHolder
import com.habitrpg.common.habitica.extensions.inflate

class PartyMemberRecyclerViewAdapter : BaseRecyclerViewAdapter<Member, GroupMemberViewHolder>() {
    var leaderID: String? = null

    var onUserClicked: ((String) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupMemberViewHolder {
        return GroupMemberViewHolder(parent.inflate(R.layout.party_member))
    }

    override fun onBindViewHolder(
        holder: GroupMemberViewHolder,
        position: Int
    ) {
        holder.bind(data[position], leaderID, null)
        holder.onClickEvent = {
            onUserClicked?.invoke(data[position].id)
        }
    }
}
