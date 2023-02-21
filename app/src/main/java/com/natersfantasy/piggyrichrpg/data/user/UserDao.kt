package com.natersfantasy.piggyrichrpg.data.user

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = IGNORE)
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM User WHERE id = :id")
    fun getCurrentUser(id: Int): Flow<User?>?

    @Query("SELECT * FROM User")
    fun getAllUser(): Flow<List<User>>

}