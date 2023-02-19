package com.natersfantasy.piggyrichrpg.data.user

interface UserRepository  {
    suspend fun addUser(user: User)
    suspend fun  getCurrentUserData(id: Int): User?
}

class UserRepositoryImpl(
    private val dao: UserDao
): UserRepository {
    override suspend fun addUser(user: User) {
        dao.addUser(user)
    }

    override suspend fun getCurrentUserData(id: Int): User? {
        return dao.getCurrentUserData(id)
    }
}