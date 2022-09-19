package com.example.chapter4topic4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter4topic4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("student", Context.MODE_PRIVATE)


        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this,"Data berhasil disimpan",Toast.LENGTH_SHORT).show()
        }
        binding.btnView.setOnClickListener {
            viewData()
        }
        binding.btnClear.setOnClickListener {
            clearData()
        }
    }

    fun saveData(){
        var getNim = Integer.parseInt(binding.etInputId.text.toString())
        var getNama = binding.etInputName.text.toString()

        var addData = sharedPref.edit()
        addData.putInt("nim",getNim)
        addData.putString("nama",getNama)
        addData.apply()
    }

    fun viewData(){
        binding.tvShowId.text = "Nim : "+sharedPref.getInt("nim",0)
        binding.tvShowName.text = "Name : "+ sharedPref.getString("nama","")
    }
    fun clearData(){
        var pref = sharedPref.edit()
        pref.clear()
        pref.apply()

        binding.tvShowName.setText("")
        binding.tvShowId.setText("")

    }
}