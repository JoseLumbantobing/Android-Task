package com.dia.dia4_android.di

import android.content.Context
import androidx.room.Room
import com.dia.dia4_android.room.AppDatabase
import com.dia.dia4_android.retrofit.ApiService
import com.dia.dia4_android.retrofit.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiaModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitHelper.apiService
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "login-db")
            .build()
    }
}