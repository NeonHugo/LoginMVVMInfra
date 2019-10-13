package br.com.nmsystems.loginmvvm.injection.module

import androidx.lifecycle.ViewModel
import br.com.nmsystems.loginmvvm.ui.act001.di.module.MAViewModelModule
import br.com.nmsystems.loginmvvm.ui.act002.di.module.FAViewModelModule
import dagger.MapKey
import dagger.Module
import kotlin.reflect.KClass

@Module(
    includes = [
        MAViewModelModule::class,
        FAViewModelModule::class
    ]
)
class ViewModelModule {

    @MustBeDocumented
    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

}