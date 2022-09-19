package com.example.chapter4topic4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4topic4.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var binding : ActivityFirstBinding
    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shared = getSharedPreferences("USERNAME",Context.MODE_PRIVATE)

        binding.btnSend.setOnClickListener {
            var getUsername = binding.inputUsername.text.toString()

            var addUsername = shared.edit()
            addUsername.putString("username",getUsername)
            addUsername.apply()
            var intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}