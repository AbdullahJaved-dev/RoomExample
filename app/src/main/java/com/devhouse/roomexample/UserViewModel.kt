package com.devhouse.roomexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Created by Abdullah on 3/15/2021.
 */
class UserViewModel(private val repository: DataRepository) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    private val _allUsers = MutableLiveData<List<User>>(ArrayList())
    val allUsers: LiveData<List<User>>
        get() = _allUsers

    fun getAllUsers() {
        viewModelScope.launch {
            _allUsers.postValue(repository.getAllUsers())
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}