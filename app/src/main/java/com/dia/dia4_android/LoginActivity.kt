package com.dia.dia4_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dia.dia4_android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textContent = binding.tvText.text
        Toast.makeText(this@LoginActivity, "$textContent", Toast.LENGTH_SHORT).show()

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            validateLogin(email, password)
        }
    }

    private fun validateLogin(email: String, password: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            binding.btnLogin.setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            }
        } else {
            showToast("Login invalid. Please fill email and password!")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}