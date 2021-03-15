package com.devhouse.roomexample

/**
 * Created by Abdullah on 3/15/2021.
 */
class DataRepository(private val dao: UserDAO) {

    suspend fun getAllUsers(): List<User> {
        return dao.getAllUsers()
    }

    suspend fun insertUser(user: User) {
        dao.insert(user)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

}