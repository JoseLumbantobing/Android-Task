package com.dia.dia4_android.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dia.dia4_android.retrofit.ApiService
import com.dia.dia4_android.register.RegisterData
import com.dia.dia4_android.retrofit.RetrofitHelper
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {
    private val registerLiveData = MutableLiveData<RegisterData>()
    val registerData: LiveData<RegisterData> = registerLiveData

    private val registerValidationLiveData = MutableLiveData<RegisterValidationData>()
    val registerValidation: LiveData<RegisterValidationData> = registerValidationLiveData

    private val apiService = RetrofitHelper.apiService

    fun register(name: String, phone: String, email: String, password: String) {
        viewModelScope.launch {
            val registerResponse = apiService.register(name, phone, email, password)
            if (registerResponse.isSuccessful) {
                val response = registerResponse.body()
                response?.let {
                    if (it.success) {
                        it.data?.let {
                            registerData -> registerLiveData.value = registerData
                        }
                        val registerValidationData = RegisterValidationData(true, "Register berhasil")
                        registerValidationLiveData.value = registerValidationData
                    } else {
                        val error = RegisterValidationData(false, "Register gagal")
                        registerValidationLiveData.value = error
                    }
                }
            } else {
                val error = RegisterValidationData(false, "Register response gagal")
                registerValidationLiveData.value = error
            }
        }
    }
}