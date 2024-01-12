package com.dia.dia4_android.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val userId: Int,

    @ColumnInfo(name = "name")
    val userName: String,

    @ColumnInfo(name = "email")
    val userEmail: String,

    @ColumnInfo(name = "phone")
    val userPhone: String,

    @ColumnInfo(name = "picture")
    val userPicture: String?
)