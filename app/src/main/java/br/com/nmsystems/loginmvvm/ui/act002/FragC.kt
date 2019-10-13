package br.com.nmsystems.loginmvvm.ui.act002

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.nmsystems.loginmvvm.R
import br.com.nmsystems.loginmvvm.base.BaseFragment
import kotlinx.android.synthetic.main.fragc.*

import kotlin.reflect.KClass

class FragC : BaseFragment<FragsCViewModel>() {

    override fun getViewModelClass(): KClass<FragsCViewModel> {
        return FragsCViewModel::class
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_counter.setOnClickListener {
            viewModel.counter()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getResults().observe(this, Observer { count ->
            Log.d("FragS", "FragC - $count")
        })
    }

    override fun onDestroy() {
        Log.d("FragS", "FragC onDestroy")

        super.onDestroy()
    }

}