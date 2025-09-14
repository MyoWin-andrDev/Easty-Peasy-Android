package com.myowin.eastypeasy.view.activity


import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.ActivityHomeBinding
import com.myowin.eastypeasy.model.uimodel.home.CuisineModel
import com.myowin.eastypeasy.model.uimodel.home.RestaurantModel
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

     //   binding.tvMain.setText("adjsfklajsdlfjksdjf")
        // Create test data
        val testRestaurantList = listOf(
            RestaurantModel(
                restaurantImage = R.drawable.the_collective_pattaya,
                restaurantName = "Italian Bistro",
                specialty = "Pasta & Pizza",
                rating = 4.5f,
                distance = 1.2f
            ),
            RestaurantModel(
                restaurantImage = R.drawable.the_collective_pattaya,
                restaurantName = "Sushi Palace",
                specialty = "Japanese Cuisine",
                rating = 4.8f,
                distance = 2.5f
            ),
            // Add more test items as needed
        )
        val testingCuisineList = listOf(
            CuisineModel(
                img = R.drawable.cuisine,
                name = "Noodle"
            ),
            CuisineModel(
                img = R.drawable.american_breakfast,
                name = "Coffee"
            )
        )
        binding.rvRestaurantNearYou.adapter = RestaurantAdapter(testRestaurantList)
        binding.rvPopularRestaurant.adapter = RestaurantAdapter(testRestaurantList)
        binding.rvCuisine.adapter = CuisineAdapter(testingCuisineList)
    }
}