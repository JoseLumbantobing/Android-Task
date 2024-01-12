package com.dia.dia4_android.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun saveUser(user: User)

    @Query("delete from user")
    suspend fun deleteAllUsers()

    @Query("select * from user")
    fun getUser(): Flow<User>
}