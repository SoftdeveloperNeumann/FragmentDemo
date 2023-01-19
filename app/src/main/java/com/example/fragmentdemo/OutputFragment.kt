package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentdemo.databinding.FragmentOutputBinding


class OutputFragment : Fragment() {

    lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOutputBinding.inflate(inflater,container,false)

        binding.tvFragmentOutput.text = arguments?.getString("city","keine Stadt vorhanden") ?: "ohne Argumente aufgerufen"

        return binding.root
    }


}