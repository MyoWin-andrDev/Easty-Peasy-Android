package com.myowin.eastypeasy.view.activity


import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.myowin.eastypeasy.databinding.ActivityHomeBinding
import com.myowin.eastypeasy.util.testRestaurantList
import com.myowin.eastypeasy.util.testingCuisineList
import com.myowin.eastypeasy.view.adapter.home.CuisineAdapter
import com.myowin.eastypeasy.view.adapter.home.RestaurantAdapter
import com.myowin.eastypeasy.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.rvRestaurantNearYou.adapter = RestaurantAdapter(testRestaurantList)
        binding.rvPopularRestaurant.adapter = RestaurantAdapter(testRestaurantList)
        binding.rvCuisine.adapter = CuisineAdapter(testingCuisineList)
    }
}