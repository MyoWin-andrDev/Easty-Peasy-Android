//package com.myowin.eastypeasy.view.fragment.restaurant_detail
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.viewbinding.library.fragment.viewBinding
//import com.myowin.eastypeasy.R
//import com.myowin.eastypeasy.databinding.FragmentDessertsBinding
//import com.myowin.eastypeasy.util.testCakes
//import com.myowin.eastypeasy.view.adapter.restaurant_detail.MenuAdapter
//
//
//class DessertsFragment : Fragment(R.layout.fragment_desserts) {
//    private lateinit var binding : FragmentDessertsBinding
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentDessertsBinding.bind(view)
//        binding.rvMenu.adapter = MenuAdapter(testCakes)
//    }
//}