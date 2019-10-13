package br.com.nmsystems.loginmvvm.ui.act001.di.module

import br.com.nmsystems.loginmvvm.ui.act001.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MAModule {

    @ContributesAndroidInjector
    abstract fun  mainActivity(): MainActivity

}