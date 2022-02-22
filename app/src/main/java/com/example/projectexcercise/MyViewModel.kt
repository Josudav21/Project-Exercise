package com.example.projectexcercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>(listOf())
    val users: LiveData<List<User>> = _users

    fun insertUser(user: User) = viewModelScope.launch {
        var placeholder = users.value!!.toMutableList()
        placeholder.add(user)

        _users.value = placeholder
    }
}