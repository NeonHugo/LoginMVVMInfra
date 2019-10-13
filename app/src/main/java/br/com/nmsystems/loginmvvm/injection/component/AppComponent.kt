package br.com.nmsystems.loginmvvm.injection.component

import android.app.Application
import br.com.nmsystems.loginmvvm.injection.AppBase
import br.com.nmsystems.loginmvvm.injection.module.ActivitiesModule
import br.com.nmsystems.loginmvvm.injection.module.AppModule
import br.com.nmsystems.loginmvvm.injection.module.DataBaseModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
* Created By neomatrix on 3/28/19
*/
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivitiesModule::class,
        DataBaseModule::class
    ]
)
interface AppComponent : AndroidInjector<AppBase> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: AppBase)
}