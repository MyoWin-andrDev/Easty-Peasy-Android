package com.myowin.eastypeasy.view.fragment.restaurant_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.FragmentDrinksBinding
import com.myowin.eastypeasy.util.testDrinks
import com.myowin.eastypeasy.view.adapter.restaurant_detail.MenuAdapter

class MenuFragment : Fragment(R.layout.fragment_drinks){
    private lateinit var binding : FragmentDrinksBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDrinksBinding.bind(view)
        binding.rvMenu.adapter = MenuAdapter(testDrinks)
    }
}