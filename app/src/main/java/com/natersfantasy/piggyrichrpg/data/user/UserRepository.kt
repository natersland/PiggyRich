package com.natersfantasy.piggyrichrpg.data.user

import kotlinx.coroutines.flow.Flow

interface UserRepository  {
    suspend fun addUser(user: User)
    suspend fun  getCurrentUser(userId: Int?): Flow<User?>?
    fun  getAllUsers(): Flow<List<User>>
}

class UserRepositoryImpl(
    private val userDao: UserDao
): UserRepository {
    override suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    override suspend fun getCurrentUser(userId: Int?): Flow<User?>?{
        return userId?.let { userDao.getCurrentUser(it) }
    }

    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUser()
    }
}