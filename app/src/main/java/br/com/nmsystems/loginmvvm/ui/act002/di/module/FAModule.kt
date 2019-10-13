package br.com.nmsystems.loginmvvm.ui.act002.di.module

import br.com.nmsystems.loginmvvm.ui.act002.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FAModule {

    @ContributesAndroidInjector
    abstract fun fragsActivity(): FragsActivity

    @ContributesAndroidInjector
    abstract fun fragA(): FragA

    @ContributesAndroidInjector
    abstract fun fragB(): FragB

    @ContributesAndroidInjector
    abstract fun fragC(): FragC

    @ContributesAndroidInjector
    abstract fun fragD(): FragD
}