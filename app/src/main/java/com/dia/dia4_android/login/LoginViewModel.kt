package com.dia.dia4_android.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dia.dia4_android.room.AppDatabase
import com.dia.dia4_android.room.User
import com.dia.dia4_android.retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
) : ViewModel() {

    private val loginValidationLiveData = MutableLiveData<LoginValidationData>()
    val loginValidation: LiveData<LoginValidationData> = loginValidationLiveData

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val loginResponse = apiService.login(email, password)
            if (loginResponse.isSuccessful) {
                val response = loginResponse.body()
                response?.let {
                    if (it.success) {
                        it.data?.let { loginData ->
                            val user = User(
                                userId = loginData.userId,
                                userName = loginData.userName,
                                userEmail = loginData.userEmail,
                                userPhone = loginData.userPhone,
                                userPicture = loginData.userPicture ?: "Tidak ada gambar"
                            )
                            appDatabase.userDao().deleteAllUsers()
                            appDatabase.userDao().saveUser(user)
                        }
                        val loginValidationData = LoginValidationData(true, "Login berhasil")
                        loginValidationLiveData.value = loginValidationData
                    } else {
                        val error = LoginValidationData(false, "Login gagal")
                        loginValidationLiveData.value = error
                    }
                }
            } else {
                val error = LoginValidationData(false, "Login response gagal")
                loginValidationLiveData.value = error
            }
        }
    }
}