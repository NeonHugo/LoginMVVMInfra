package br.com.nmsystems.loginmvvm.injection.module

import android.content.Context
import br.com.nmsystems.loginmvvm.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideUserDao(context: Context): UserDao {
        return UserDao()
    }

}