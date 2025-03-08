package com.habitrpg.wearos.habitica.ui.viewHolders.tasks

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.databinding.RowHabitBinding
import com.habitrpg.wearos.habitica.models.tasks.Task
import com.habitrpg.wearos.habitica.ui.views.TaskTextView

class HabitViewHolder(itemView: View) : TaskViewHolder(itemView) {
    private val binding = RowHabitBinding.bind(itemView)
    override val titleView: TaskTextView
        get() = binding.title

    init {
        binding.habitButton.setOnClickListener {
            onTaskScore?.invoke()
        }
    }

    override fun bind(data: Task) {
        super.bind(data)

        if (data.up == true && data.down == true) {
            binding.habitButtonIcon.setBackgroundResource(R.drawable.habit_diagonal)
            binding.habitButtonIcon.setImageResource(R.drawable.watch_habit_posneg)
        } else {
            binding.habitButtonIcon.setBackgroundResource(R.drawable.habit_button_round)
            if (data.down == true) {
                binding.habitButtonIcon.setImageResource(R.drawable.watch_habit_negative)
            } else {
                binding.habitButtonIcon.setImageResource(R.drawable.watch_habit_positive)
            }
        }
        if (data.up != true && data.down != true) {
            binding.habitButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, R.color.watch_gray_100))
            binding.habitButtonIcon.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, R.color.watch_gray_5))
            binding.habitButtonIcon.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, R.color.watch_gray_100))
        } else {
            binding.habitButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, data.lightTaskColor))
            binding.habitButtonIcon.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, data.mediumTaskColor))
            binding.habitButtonIcon.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, R.color.white))
        }
    }
}
