package com.myowin.eastypeasy.view.activity

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.ActivityRestaurantDetailBinding
import com.myowin.eastypeasy.view.fragment.restaurant_detail.DessertsFragment
import com.myowin.eastypeasy.view.fragment.restaurant_detail.MenuFragment
import com.myowin.eastypeasy.view.fragment.restaurant_detail.MainDishesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantDetailActivity : AppCompatActivity() {
    private val binding : ActivityRestaurantDetailBinding by viewBinding()
    //private val viewModel :
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupFragment()
    }

    private fun setupFragment() {
        var fragment : Fragment = MainDishesFragment()
        replaceFragment(fragment)
        binding.tlResto.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> fragment = MainDishesFragment()
                    1 -> fragment = MenuFragment()
                    2 -> fragment = DessertsFragment()
                }
                replaceFragment(fragment)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
    private fun replaceFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack("").commit()
    }
}