package com.example.chapter4topic4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4topic4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding : ActivitySecondBinding
    lateinit var prefget : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        getData
        prefget = this.getSharedPreferences("USERNAME",Context.MODE_PRIVATE)
        var getData = prefget.getString("username","")


        binding.txtUsername.text = getData
    }
}