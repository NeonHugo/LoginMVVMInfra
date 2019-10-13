package br.com.nmsystems.loginmvvm.ui.act002

import android.content.Intent
import android.os.Bundle
import br.com.nmsystems.loginmvvm.R
import br.com.nmsystems.loginmvvm.base.BaseActivity
import br.com.nmsystems.loginmvvm.factory.addFragmentToActivity
import br.com.nmsystems.loginmvvm.factory.replaceFragment
import br.com.nmsystems.loginmvvm.ui.act001.MainActivity
import kotlinx.android.synthetic.main.content_frags.*
import kotlin.reflect.KClass

class FragsActivity : BaseActivity<FragsActivityViewModel>() {

    private lateinit var fragA: FragA
    private lateinit var fragB: FragB
    private lateinit var fragC: FragC
    private lateinit var fragD: FragD

    private var index = 1

    override fun getViewModelClass(): KClass<FragsActivityViewModel> {
        return FragsActivityViewModel::class
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frags)

        iniVars()
        iniActions()
    }

    override fun iniVars() {
        super.iniVars()
        fragA = FragA()
        fragB = FragB()
        fragC = FragC()
        fragD = FragD()

        changeFragment(index)
    }

    fun changeFragment(index: Int) {
        this.index = index

        when(index) {
            1 -> replaceFragment(fragA, R.id.ll_frame2)
            2 -> replaceFragment(fragB, R.id.ll_frame2)
            3 -> replaceFragment(fragC, R.id.ll_frame2)
            4 -> replaceFragment(fragD, R.id.ll_frame2)
        }
    }

    override fun iniActions() {
        super.iniActions()

        btn_fa.setOnClickListener {
            changeFragment(1)
        }

        btn_fb.setOnClickListener {
            changeFragment(2)
        }

        btn_fc.setOnClickListener {
            changeFragment(3)
        }

        btn_fd.setOnClickListener {
            changeFragment(4)
        }
    }

    override fun onBackPressed() {
        callMainActivity()
    }

    private fun callMainActivity() {
        val mIntent = Intent(this, MainActivity::class.java)
        startActivity(mIntent)

        finish()
    }
}