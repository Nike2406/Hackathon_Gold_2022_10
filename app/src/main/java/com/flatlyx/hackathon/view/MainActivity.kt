package com.flatlyx.hackathon.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.ActivityMainBinding
import com.yandex.mapkit.MapKitFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ya.api
        MapKitFactory.setApiKey("de65b04e-9dd7-4a8e-a97f-22d71032b780");

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out
            )
            .replace(R.id.place_holder, MapFragment.newInstance())
            .commit()
    }
}