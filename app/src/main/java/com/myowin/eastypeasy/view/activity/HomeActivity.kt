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
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupObservers()
        loadInitialData()



        binding.rvCuisine.adapter = CuisineAdapter(testingCuisineList)
    }

    private fun loadInitialData(){
        viewModel.loadRestaurants()
    }

    private fun setupObservers() {

        lifecycleScope.launch {
            viewModel.restaurants.collect { restaurants ->
                Timber.d("Restaurants updated: ${restaurants.size} items")
                if (restaurants.isNotEmpty()) {
                    binding.rvRestaurantNearYou.adapter = RestaurantAdapter(restaurants)
                    binding.rvPopularRestaurant.adapter = RestaurantAdapter(restaurants)
                } else {
                    Timber.d("Restaurants list is empty")
                }
            }
        }

    }


}