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
import com.example.chapter4topic4.databinding.FragmentHomeBinding
import com.example.chapter4topic4.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var sharedlogin : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedlogin = requireContext().getSharedPreferences("datauser",Context.MODE_PRIVATE)



        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment3_to_registerFragment2)
        }
        binding.btnLogin.setOnClickListener {
            var getDataUser = sharedlogin.getString("user","")
            var getDataPw = sharedlogin.getString("password","")
            var user = binding.inputUser.text.toString()
            var pw = binding.inputPw.text.toString()

            if (user.isEmpty() || pw.isEmpty()){
                Toast.makeText(context,"ISI PASSWORD DAN USERNAME ANDA",Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (user == getDataUser.toString() && pw == getDataPw.toString()){
                findNavController().navigate(R.id.action_loginFragment3_to_homeFragment2)
                Toast.makeText(context,"Anda Berhasil Login",Toast.LENGTH_SHORT).show()

            }else if (user != getDataUser.toString() || pw != getDataPw.toString()){
                Toast.makeText(context,"USERNAME DAN PASSWORD ANDA SALAH",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }




        }



    }


}