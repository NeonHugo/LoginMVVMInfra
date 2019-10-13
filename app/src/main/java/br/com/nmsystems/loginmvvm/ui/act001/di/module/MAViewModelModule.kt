package br.com.nmsystems.loginmvvm.ui.act001.di.module

import androidx.lifecycle.ViewModel
import br.com.nmsystems.loginmvvm.dao.UserDao
import br.com.nmsystems.loginmvvm.injection.module.ViewModelModule
import br.com.nmsystems.loginmvvm.ui.act001.MainActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class MAViewModelModule {

    @Provides
    @IntoMap
    @ViewModelModule.ViewModelKey(MainActivityViewModel::class)
    fun mainActivityViewModel(userDao: UserDao): ViewModel {
        return MainActivityViewModel(userDao)
    }

}