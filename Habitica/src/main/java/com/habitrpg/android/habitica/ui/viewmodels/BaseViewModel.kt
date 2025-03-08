package xyz.prfn.android.habitica.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import xyz.prfn.android.habitica.data.UserRepository
import xyz.prfn.android.habitica.models.user.User
import com.habitrpg.common.habitica.helpers.ExceptionHandler
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    val userRepository: UserRepository,
    val userViewModel: MainUserViewModel
) : ViewModel() {
    val user: LiveData<User?> by lazy {
        userViewModel.user
    }

    override fun onCleared() {
        userRepository.close()
        super.onCleared()
    }

    fun updateUser(
        path: String,
        value: Any
    ) {
        viewModelScope.launch(ExceptionHandler.coroutine()) {
            userRepository.updateUser(path, value)
        }
    }
}
