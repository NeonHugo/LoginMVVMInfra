package br.com.nmsystems.loginmvvm.base

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import br.com.nmsystems.loginmvvm.R
import br.com.nmsystems.loginmvvm.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<VModel : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: VModel

    protected abstract fun getViewModelClass(): KClass<VModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected open fun iniVars() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(getViewModelClass().java)

        window.navigationBarColor = ContextCompat.getColor(
            this,
            R.color.colorPrimaryDark
        )
    }

    protected open fun iniActions() {
    }

}