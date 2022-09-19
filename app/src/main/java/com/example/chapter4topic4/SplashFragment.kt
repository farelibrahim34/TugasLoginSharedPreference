package com.example.chapter4topic4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.chapter4topic4.databinding.FragmentLoginBinding
import com.example.chapter4topic4.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    lateinit var binding : FragmentSplashBinding
    lateinit var shared : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_splash, container, false)
        binding = FragmentSplashBinding.inflate(layoutInflater)
        val view = binding.root

        Handler(Looper.myLooper()!!).postDelayed({

            shared = requireContext().getSharedPreferences("datauser",Context.MODE_PRIVATE)
            if (shared.getString("user","").equals("")){
                findNavController().navigate(R.id.action_splashFragment2_to_loginFragment3)

            }else if(shared.getString("user","")!!.length !=0){
                findNavController().navigate(R.id.action_splashFragment2_to_homeFragment2)
            }
//            findNavController().navigate(R.id.action_splashFragment2_to_loginFragment3)



        },3000)
        return view
    }

}