package com.example.roomapp.repository

import androidx.lifecycle.LiveData
import com.example.roomapp.data.UserDAO
import com.example.roomapp.model.User

class UserRepository(private val userDAO: UserDAO) {

    val readAllData: LiveData<List<User>> = userDAO.readAllData()

    suspend fun addUser(user: User) {
        userDAO.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDAO.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDAO.deleteUser(user)
    }

    suspend fun deleteAllUser() {
        userDAO.deleteAllUser()
    }
}