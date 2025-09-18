//package com.myowin.eastypeasy.view.fragment.restaurant_detail
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.View
//import androidx.recyclerview.widget.GridLayoutManager
//import com.myowin.eastypeasy.R
//import com.myowin.eastypeasy.databinding.FragmentMainDishesBinding
//import com.myowin.eastypeasy.util.testDishes
//import com.myowin.eastypeasy.view.adapter.restaurant_detail.MenuAdapter
//
//class MainDishesFragment : Fragment(R.layout.fragment_menu){
//    private lateinit var binding : FragmentMainDishesBinding
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentMainDishesBinding.bind(view)
//        binding.rvMenu.layoutManager = GridLayoutManager(requireContext(), 2)
//        binding.rvMenu.adapter = MenuAdapter(testDishes)
//    }
//}