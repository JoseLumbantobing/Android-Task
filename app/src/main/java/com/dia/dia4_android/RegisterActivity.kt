package com.dia.dia4_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dia.dia4_android.databinding.ActivityRegisterBinding
import com.dia.dia4_android.register.RegisterViewModel
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val userName = binding.etName.text.toString()
            val phoneNumber = binding.etPhoneNumber.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (validateUsername(userName) && validatePhoneNumber(phoneNumber) && validateEmail(email) && validatePassword(password)) {
                viewModel.register(userName, phoneNumber, email, password)
            } else {
                Toast.makeText(this, "Data tidak sesuai", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateUsername(userName: String): Boolean {
        return userName.length in 6 .. 20
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        val patternValidation = Regex("08\\\\d{8,12}")
        return patternValidation.matches(phoneNumber)
    }

    private fun validateEmail(email: String): Boolean {
        val patternValidation = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}\$")
        return patternValidation.matches(email)
    }

    private fun validatePassword(password: String): Boolean {
        val patternValidation = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@\$!%*?&])[A-Za-z\\\\d@\$!%*?&]{8,}\$")
        return patternValidation.matches(password)
    }
}