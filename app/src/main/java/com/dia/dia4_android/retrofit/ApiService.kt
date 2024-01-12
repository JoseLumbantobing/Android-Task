package com.dia.dia4_android.retrofit

import com.dia.dia4_android.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("v1/auth/register")
    suspend fun register(
        @Field("user_name") userName: String,
        @Field("user_phone") userPhone: String,
        @Field("user_email") userEmail: String,
        @Field("user_password") userPassword: String
    ): Response<RegisterResponse>

}