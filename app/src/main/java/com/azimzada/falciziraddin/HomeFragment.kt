package com.azimzada.falciziraddin.core.bottom_navigation_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.azimzada.falciziraddin.MagicBallActivity
import com.azimzada.falciziraddin.R
import com.azimzada.falciziraddin.TarotCartActivity
import com.azimzada.falciziraddin.databinding.ActivityHomeBinding
import com.azimzada.falciziraddin.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.firstCard.setOnClickListener {
            val intent = Intent(requireContext(), TarotCartActivity::class.java)
            startActivity(intent)
        }


        binding.card2.setOnClickListener()
        {
            val intent = Intent(requireContext(), MagicBallActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}