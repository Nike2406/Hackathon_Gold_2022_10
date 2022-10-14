package com.flatlyx.hackathon.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.ActivityMainBinding
import com.flatlyx.hackathon.databinding.FragmentLoginBinding
import com.flatlyx.hackathon.databinding.FragmentRegistrationBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.place_holder, LoginFragment.newInstance())
            .commit()
    }
}