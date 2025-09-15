package com.myowin.eastypeasy.view.activity


import android.os.Bundle
import android.util.Log
import android.viewbinding.library.activity.viewBinding
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.myowin.eastypeasy.databinding.ActivityHomeBinding
import com.myowin.eastypeasy.util.testRestaurantList
import com.myowin.eastypeasy.util.testingCuisineList
import com.myowin.eastypeasy.view.adapter.home.CuisineAdapter
import com.myowin.eastypeasy.view.adapter.home.RestaurantAdapter
import com.myowin.eastypeasy.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupObserver()
        // Load initial data
        viewModel.loadRestaurants()



        binding.rvCuisine.adapter = CuisineAdapter(testingCuisineList)
    }

    private fun setupObserver() {
        lifecycleScope.launch{
            viewModel.restaurants.collect { restaurants ->
                Log.d("Restaurant", restaurants.toString())
                if(restaurants.isNotEmpty()){
                    binding.rvRestaurantNearYou.adapter = RestaurantAdapter(restaurants)
                    binding.rvPopularRestaurant.adapter = RestaurantAdapter(restaurants)
                }
            }
        }
    }


}