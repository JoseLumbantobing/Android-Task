package com.dia.dia4_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dia.dia4_android.R
import com.dia.dia4_android.databinding.ActivityFragmentBinding
import com.dia.dia4_android.fragment.FirstFragment

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(binding.container.id, FirstFragment.newInstance("", ""))
        showFragment(binding.container2.id, FirstFragment.newInstance("", ""))
    }

    private fun showFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment)
            .commitAllowingStateLoss()
    }
}