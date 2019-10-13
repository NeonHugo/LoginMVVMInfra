package br.com.nmsystems.loginmvvm.ui.act001

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.nmsystems.loginmvvm.R
import br.com.nmsystems.loginmvvm.base.BaseActivity
import br.com.nmsystems.loginmvvm.factory.DB
import br.com.nmsystems.loginmvvm.factory.ID
import br.com.nmsystems.loginmvvm.ui.act002.FragsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlin.reflect.KClass

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override fun getViewModelClass(): KClass<MainActivityViewModel> {
        return MainActivityViewModel::class
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        iniVars()
        iniActions()
    }

    override fun iniVars() {
        super.iniVars()

        viewModel.getResults().observe(this, Observer { user ->
            user?.let {
                callFragsActivity()
            } ?: mensagem()
        })
    }

    private fun mensagem() {
        Toast.makeText(
            this,
            "Erro",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun callFragsActivity() {
       val mIntent = Intent(this, FragsActivity::class.java)
        startActivity(mIntent)

        finish()
    }

    override fun iniActions() {
        btn_login.setOnClickListener {
            viewModel.loginUseCase(
                login_id_edit_text.text.toString().ID(),
                login_password_edit_text.text.toString().DB()
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
