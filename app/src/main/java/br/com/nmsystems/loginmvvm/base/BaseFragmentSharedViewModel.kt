package br.com.nmsystems.loginmvvm.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import br.com.nmsystems.loginmvvm.factory.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragmentSharedViewModel<VModel : ViewModel> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: VModel

    protected abstract fun getViewModelClass(): KClass<VModel>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProviders.of(it, viewModelFactory)
                .get(getViewModelClass().java)
        }
    }

}