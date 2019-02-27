package com.workshop.aroundme.data

import com.workshop.aroundme.data.model.UserEntity
import com.workshop.aroundme.local.datasource.UserLocalDataSource

class UserRepository(private val localDataSource: UserLocalDataSource) {

    fun login(user: UserEntity) {
        localDataSource.login(user)
    }

    fun isLoggedIn() = localDataSource.getUser() != null

}