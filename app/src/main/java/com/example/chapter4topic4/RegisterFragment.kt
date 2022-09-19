package com.example.chapter4topic4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chapter4topic4.databinding.FragmentLoginBinding
import com.example.chapter4topic4.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding
    lateinit var shared : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.btnDaftar.setOnClickListener {
            register()
            Toast.makeText(context,"Terimakasih Anda Telah Registrasi",Toast.LENGTH_SHORT).show()

        }
        binding.btnKeLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment2_to_loginFragment3)
        }

    }
    fun register(){
        var getUsername = binding.registUser.text.toString()
        var getFname = binding.regisFullname.text.toString()
        var getPw = binding.regisPw.text.toString()
        var getUpw = binding.registUlangPw.text.toString()

        var addDataUser = shared.edit()
        addDataUser.putString("user",getUsername)
        addDataUser.putString("fullname",getFname)
        addDataUser.putString("password",getPw)
        addDataUser.putString("ulangpassword",getUpw)
        addDataUser.apply()
    }

}