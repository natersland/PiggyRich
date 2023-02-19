package com.natersfantasy.piggyrichrpg.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    val name: String,
    val level: Int,
    val savingMoney: Int,
    @PrimaryKey val id: Int? = null
)