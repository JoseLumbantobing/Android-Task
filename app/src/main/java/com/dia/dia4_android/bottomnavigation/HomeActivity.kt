package com.dia.dia4_android.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dia.dia4_android.R
import com.dia.dia4_android.databinding.ActivityHomeBinding
import com.dia.dia4_android.fragment.FavoriteFragment
import com.dia.dia4_android.fragment.HomeFragment
import com.dia.dia4_android.fragment.ProfileFragment
import com.dia.dia4_android.fragment.TransactionFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeMenu -> {
                    showFragment(binding.container.id, HomeFragment.newInstance("", ""))
                    true
                }
                R.id.transactionMenu -> {
                    showFragment(binding.container.id, TransactionFragment.newInstance("", ""))
                    true
                }
                R.id.profileMenu -> {
                    showFragment(binding.container.id, ProfileFragment.newInstance("", ""))
                    true
                }
                else -> {false}
            }
        }
    }

    private fun showFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment)
            .commitAllowingStateLoss()
    }
}