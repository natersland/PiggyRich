package com.natersfantasy.piggyrichrpg.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var name: String,
    var level: Int,
    var savingMoney: Int,
    @PrimaryKey val id: Int? = null
)