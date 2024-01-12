package com.dia.dia4_android.retrofit

import com.dia.dia4_android.login.LoginResponse
import com.dia.dia4_android.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @FormUrlEncoded
    @POST("v1/auth/register")
    suspend fun register(
        @Field("user_name") userName: String,
        @Field("user_phone") userPhone: String,
        @Field("user_email") userEmail: String,
        @Field("user_password") userPassword: String
    ): Response<RegisterResponse>

    @GET("v1/auth/login")
    suspend fun login(
        @Query("user_email") userEmail: String,
        @Query("password") userPassword: String
    ): Response<LoginResponse>
}