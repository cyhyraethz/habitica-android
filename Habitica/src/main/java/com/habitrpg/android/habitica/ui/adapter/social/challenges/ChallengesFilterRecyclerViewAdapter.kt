package xyz.prfn.android.habitica.ui.adapter.social.challenges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.databinding.DialogChallengeFilterGroupItemBinding
import xyz.prfn.android.habitica.models.social.Group

class ChallengesFilterRecyclerViewAdapter(entries: List<Group>) :
    RecyclerView.Adapter<ChallengesFilterRecyclerViewAdapter.ChallengeViewHolder>() {
    private val entries: List<Group>
    val checkedEntries: MutableList<Group> = mutableListOf()

    init {
        this.entries = ArrayList(entries)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChallengeViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.dialog_challenge_filter_group_item, parent, false)
        return ChallengeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ChallengeViewHolder,
        position: Int
    ) {
        holder.bind(entries[position], checkedEntries)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    class ChallengeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = DialogChallengeFilterGroupItemBinding.bind(itemView)

        fun bind(
            group: Group,
            checkedEntries: MutableList<Group>
        ) {
            binding.root.text = group.name
            binding.root.isChecked = checkedEntries.contains(group)
            binding.root.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && !checkedEntries.contains(group)) {
                    checkedEntries.add(group)
                } else if (!isChecked && checkedEntries.contains(group)) {
                    checkedEntries.remove(group)
                }
            }
        }
    }
}
