package br.com.nmsystems.loginmvvm.injection.module

import br.com.nmsystems.loginmvvm.ui.act001.MainActivity
import br.com.nmsystems.loginmvvm.ui.act001.di.module.MAModule
import br.com.nmsystems.loginmvvm.ui.act001.di.module.MAViewModelModule
import br.com.nmsystems.loginmvvm.ui.act002.di.module.FAModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        MAModule::class,
        FAModule::class
    ]
)
abstract class ActivitiesModule