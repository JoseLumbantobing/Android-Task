package com.dia.dia4_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.dia.dia4_android.bottomnavigation.HomeActivity
import com.dia.dia4_android.databinding.ActivityLoginBinding
import com.dia.dia4_android.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (validateEmail(email) && validatePassword(password)) {
                viewModel.login(email, password)
            } else {
                showToast("Login invalid. Please fill email and password!")
            }
        }

        binding.btnLogin.setOnClickListener {
            val intentHome = Intent(this, HomeActivity::class.java)
            startActivity(intentHome)
        }
    }

    private fun validateEmail(email: String): Boolean {
        return email.length in 6 .. 30
    }

    private fun validatePassword(password: String): Boolean {
        return password.length in 6 .. 30
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}