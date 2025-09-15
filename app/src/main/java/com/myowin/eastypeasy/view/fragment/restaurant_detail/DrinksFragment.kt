package com.myowin.eastypeasy.view.fragment.restaurant_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.FragmentDrinksBinding

class DrinksFragment : Fragment(R.layout.fragment_drinks){
    private lateinit var binding : FragmentDrinksBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDrinksBinding.bind(view)
    }
}