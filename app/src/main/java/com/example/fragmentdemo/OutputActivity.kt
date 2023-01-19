package com.example.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentdemo.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var city = intent.getStringExtra("city")


        binding.tvOutput.text = city
    }
}