package com.example.ryan_riley_randstad_walmart_02_12_24.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ryan_riley_randstad_walmart_02_12_24.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val countryFragment = CountryFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, countryFragment).commit()
        }
    }
}