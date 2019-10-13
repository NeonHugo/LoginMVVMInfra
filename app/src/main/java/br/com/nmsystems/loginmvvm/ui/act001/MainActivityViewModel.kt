package br.com.nmsystems.loginmvvm.ui.act001

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.nmsystems.loginmvvm.dao.UserDao
import br.com.nmsystems.loginmvvm.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext

class MainActivityViewModel(
    private val userDao: UserDao
) : ViewModel() {

    private var results: MutableLiveData<User> = MutableLiveData()

    fun getResults() : MutableLiveData<User> {
        return results
    }

    fun loginUseCase(userId: Long, password: String) {
        var user: User?

        CoroutineScope(IO).launch {
            user = userDao.getUser(userId, password)

            withContext(Main) {
                results.value = user
            }

        }
    }

}