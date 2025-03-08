package com.habitrpg.wearos.habitica.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import xyz.prfn.android.habitica.databinding.ActivityHabitDirectionBinding
import com.habitrpg.shared.habitica.models.responses.TaskDirection
import com.habitrpg.wearos.habitica.ui.viewmodels.HabitDirectionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HabitDirectionActivity : BaseActivity<ActivityHabitDirectionBinding, HabitDirectionViewModel>() {
    override val viewModel: HabitDirectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHabitDirectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        viewModel.task.observe(this) {
            if (it == null) return@observe
            val lightTaskColor = ContextCompat.getColor(this, it.lightTaskColor)
            val mediumTaskColor = ContextCompat.getColor(this, it.mediumTaskColor)
            binding.plusButton.mainTaskColor = lightTaskColor
            binding.plusButton.darkerTaskColor = mediumTaskColor
            binding.minusButton.mainTaskColor = lightTaskColor
            binding.minusButton.darkerTaskColor = mediumTaskColor
            binding.textView.text = it.text
        }

        binding.plusButton.setOnClickListener {
            val data = Intent()
            data.putExtra("direction", TaskDirection.UP.name)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
        binding.minusButton.setOnClickListener {
            val data = Intent()
            data.putExtra("direction", TaskDirection.DOWN.name)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
