package br.com.nmsystems.loginmvvm.ui.act001

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.nmsystems.loginmvvm.dao.UserDao
import br.com.nmsystems.loginmvvm.entity.User
import br.com.nmsystems.loginmvvm.factory.getTestValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class MainActivityViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI Thread")

    private lateinit var userDao: UserDao
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        userDao = UserDao()
        mainActivityViewModel = MainActivityViewModel(userDao)
    }

    @Test
    fun loginUseCase() {

        runBlocking {
            mainActivityViewModel.loginUseCase(10L, "T123")
        }

        val user: User? = mainActivityViewModel.getResults().getTestValue()

        assertEquals("Hugo", user!!.name)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }
}