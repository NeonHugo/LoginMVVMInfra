package br.com.nmsystems.loginmvvm.ui.act002

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.nmsystems.loginmvvm.dao.UserDao

class FragsActivityViewModel(
    private val userDao: UserDao
) : ViewModel() {

    private var count: Int = 0

    private var results: MutableLiveData<Int> = MutableLiveData()

    fun getResults(): MutableLiveData<Int> {
        return results
    }

    fun counter() {
        results.value = ++count
    }

}