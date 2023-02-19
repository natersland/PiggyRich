package com.natersfantasy.piggyrichrpg.tools.di

import android.app.Application
import androidx.room.Room
import com.natersfantasy.piggyrichrpg.data.user.User
import com.natersfantasy.piggyrichrpg.data.user.UserDatabase
import com.natersfantasy.piggyrichrpg.data.user.UserRepository
import com.natersfantasy.piggyrichrpg.data.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDoa())
    }
}