package com.example.fragmentdemo

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentdemo.databinding.FragmentOutputBinding


class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOutputBinding.inflate(inflater,container,false)

        // Prüfen auf Landscape Modus
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.tvFragmentOutput.text =
                arguments?.getString("city", "keine Stadt vorhanden") ?: lastValue //"ohne Argumente aufgerufen"
        }else{
            val intent = activity?.intent
            binding.tvFragmentOutput.text = intent?.getStringExtra("city") ?: "keine Stadt vorhanden"
        }
        lastValue = binding.tvFragmentOutput.text.toString()

        return binding.root
    }

    private companion object{
        var lastValue = ""
    }


}