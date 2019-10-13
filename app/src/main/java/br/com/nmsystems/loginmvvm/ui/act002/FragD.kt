package br.com.nmsystems.loginmvvm.ui.act002

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.nmsystems.loginmvvm.R
import br.com.nmsystems.loginmvvm.base.BaseFragment
import kotlinx.android.synthetic.main.fragd.*


import kotlin.reflect.KClass

class FragD : BaseFragment<FragsDViewModel>() {

    override fun getViewModelClass(): KClass<FragsDViewModel> {
        return FragsDViewModel::class
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragd, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_counter.setOnClickListener {
            viewModel.counter()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getResults().observe(viewLifecycleOwner, Observer { count ->
            Log.d("FragS", "FragD - $count")
        })
    }

    override fun onDestroy() {
        Log.d("FragS", "FragD onDestroy")

        super.onDestroy()
    }

}