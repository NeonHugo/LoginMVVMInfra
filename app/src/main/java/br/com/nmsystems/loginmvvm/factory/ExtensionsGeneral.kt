package br.com.nmsystems.loginmvvm.factory

import android.text.TextUtils.replace
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


fun <T : ViewModel> T.createFactory(): ViewModelProvider.Factory {
    val viewModel = this
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModel as T
    }
}

fun String.ID(): Long {
    return try {
        this.toLong()
    } catch (ex: Exception) {
        -1L
    }
}

fun String.DB(): String {
    return this.trim()
}

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
fun addFragmentToActivity(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    frameId: Int,
    Id: Int
) {
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(frameId, fragment, Id.toString())
    transaction.commit()
}

fun removeAllFragments(fragmentManager: FragmentManager) {
    val transition = fragmentManager.beginTransaction()
    for (fragment in fragmentManager.getFragments()) {
        transition.remove(fragment)
    }
    transition.commit()
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{replace(frameId, fragment)}
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun getCurrentFragmentIn(fragmentManager: FragmentManager, @IdRes frameId: Int): Fragment? {
    return fragmentManager.findFragmentByTag(frameId.toString())
}



