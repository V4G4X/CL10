package com.varun.login.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.varun.login.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(vararg user: User)

    @Query("SELECT * FROM user ORDER BY uid ASC")
    fun getAll(): LiveData<List<User>>

    @Update
    suspend fun updateUser(vararg user: User)

    @Delete
    suspend fun dropUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()
}
