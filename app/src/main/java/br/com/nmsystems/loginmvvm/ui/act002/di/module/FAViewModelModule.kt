package br.com.nmsystems.loginmvvm.ui.act002.di.module

import androidx.lifecycle.ViewModel
import br.com.nmsystems.loginmvvm.dao.UserDao
import br.com.nmsystems.loginmvvm.injection.module.ViewModelModule
import br.com.nmsystems.loginmvvm.ui.act002.FragsActivityViewModel
import br.com.nmsystems.loginmvvm.ui.act002.FragsCViewModel
import br.com.nmsystems.loginmvvm.ui.act002.FragsDViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class FAViewModelModule {

    @Provides
    @IntoMap
    @ViewModelModule.ViewModelKey(FragsActivityViewModel::class)
    fun fragsActivityViewModel(userDao: UserDao): ViewModel {
        return FragsActivityViewModel(userDao)
    }

    @Provides
    @IntoMap
    @ViewModelModule.ViewModelKey(FragsCViewModel::class)
    fun fragsCViewModel(userDao: UserDao): ViewModel {
        return FragsCViewModel(userDao)
    }

    @Provides
    @IntoMap
    @ViewModelModule.ViewModelKey(FragsDViewModel::class)
    fun fragsDViewModel(userDao: UserDao): ViewModel {
        return FragsDViewModel(userDao)
    }

}