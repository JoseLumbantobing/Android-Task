package com.dia.dia4_android.login

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val errorCode: String,
    val data: LoginData?
)
