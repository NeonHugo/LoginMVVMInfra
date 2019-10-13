package br.com.nmsystems.loginmvvm.dao

import br.com.nmsystems.loginmvvm.entity.User


class UserDao {

    fun getUser(userId: Long, password: String): User? {
        when {
            (userId == 10L && password == "T123") -> {
                return User(10L, "Hugo", "T123")
            }

            else -> {
                return null
            }
       }
    }

}
