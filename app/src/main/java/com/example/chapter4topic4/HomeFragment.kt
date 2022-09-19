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
import com.example.chapter4topic4.R
import com.example.chapter4topic4.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var shared : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        shared = requireContext().getSharedPreferences("datauser",Context.MODE_PRIVATE)

        var getDataUser = shared.getString("fullname","")
        binding.txtFullname.text = "Hello "+getDataUser

        binding.btnLogout.setOnClickListener {
            var pref = shared.edit()
            pref.clear()
            pref.apply()
            findNavController().navigate(R.id.action_homeFragment2_to_loginFragment3)
            Toast.makeText(context,"Anda Berhasil Logout", Toast.LENGTH_SHORT).show()

        }
    }

}