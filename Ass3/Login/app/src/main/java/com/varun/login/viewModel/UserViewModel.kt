package com.varun.login.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.varun.login.data.AppDatabase
import com.varun.login.data.UserDao
import com.varun.login.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application)  {

    private val userDao: UserDao = AppDatabase.getDatabase(application).userDao()
    val getAll: LiveData<List<User>> = userDao.getAll()

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            userDao.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            userDao.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            userDao.dropUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO){
            userDao.deleteAllUsers()
        }
    }

}