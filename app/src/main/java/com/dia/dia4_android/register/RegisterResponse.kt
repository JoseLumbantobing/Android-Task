package com.dia.dia4_android.register

data class RegisterResponse(
    val success: Boolean,
    val message: String,
    val errorCode: String,
    val data: RegisterData?
)
