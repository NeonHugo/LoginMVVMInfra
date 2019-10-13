package br.com.nmsystems.loginmvvm.injection

class LMVVMApplication : AppBase() {

    override fun onCreate() {
        super.onCreate()

        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            handleUncaughtException(thread, throwable)
        }
    }

    fun handleUncaughtException(thread: Thread, throwable: Throwable) {

    }

}