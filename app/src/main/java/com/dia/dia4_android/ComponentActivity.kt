package com.dia.dia4_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dia.dia4_android.bottomnavigation.HomeActivity
import com.dia.dia4_android.databinding.ActivityComponentBinding

class ComponentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Get View using findVyViewId
//        val textView = findViewById<TextView>(R.id.tvText)

//        Get view using binding
        val textContent = binding.tvText.text
        Toast.makeText(this@ComponentActivity, "Isi text view = $textContent", Toast.LENGTH_SHORT).show()

//        binding.btnChangeTv.setOnClickListener {
//            binding.tvText.text = "Button is clicked"
//            binding.tvText.setTextColor(getColor(R.color.Green))
//        }

        binding.btnChangeTv.setOnClickListener {
            val phone = binding.etInput.text.toString() // to get data from edittext
            binding.tvText.text = phone
            binding.tvText.setTextColor(getColor(R.color.Green))
        }

        binding.btnFragment.setOnClickListener {
            val intent = Intent(this@ComponentActivity, FragmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnBottomNavigation.setOnClickListener {
            val homeIntent = Intent(this@ComponentActivity, HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }
}