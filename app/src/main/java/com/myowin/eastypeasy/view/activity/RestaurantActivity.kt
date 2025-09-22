package com.myowin.eastypeasy.view.activity

import android.os.Bundle
import android.util.Log
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.ActivityRestaurantBinding
import com.myowin.eastypeasy.model.dto.MenuCategory
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.view.fragment.restaurant_detail.MenuFragment
import com.myowin.eastypeasy.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    private val binding: ActivityRestaurantBinding by viewBinding()
    private val viewModel: RestaurantViewModel by viewModels()

    private val restaurant by lazy { intent.getSerializableExtra("RESTAURANT_JSON")}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupClickListeners()
        setupObservers()
        setRestaurant()

    }

    private fun setupClickListeners() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.ivCart.setOnClickListener {
            // Handle cart click
        }
    }

    private fun setRestaurant() {
        if(restaurant != null){
            viewModel.setRestaurant(restaurant as RestaurantModel)
        }
    }

    private fun setupObservers() {
        observeRestaurant()
        observeMenuItems()
    }

    private fun observeRestaurant() {
        lifecycleScope.launch {
            viewModel.restaurant
                .collectLatest { restaurant ->
                Log.d("restaurant111", restaurant.toString())
                restaurant?.let {
                    updateUI(it)
                    setupTabs(it.menuCategories)
                    it.menuCategories.firstOrNull()?.let { category ->
                        viewModel.selectCategory(category.id)
                    }
                }
            }
        }
    }

    private fun observeMenuItems() {
        lifecycleScope.launch {
            viewModel.category.collectLatest { menuItems ->
                val viewType = viewModel.currentViewType.value
                updateMenuFragment(menuItems, viewType)
            }
        }
    }



    private fun updateUI(restaurant: RestaurantModel) {
        binding.tvRestoName.text = restaurant.restaurantName // Changed from name to restaurantName
        binding.tvRestaurantAddress.text = restaurant.address
        binding.tvRating.text = restaurant.rating.toString()
        binding.tvDuration.text = "${restaurant.distance} mins" // Changed from Int to Float

    }

    private fun setupTabs(categories: List<MenuCategory>) {
        binding.tlResto.removeAllTabs()

        categories.forEach { category ->
            val tab = binding.tlResto.newTab().apply {
                text = category.name
                tag = category.id
            }
            binding.tlResto.addTab(tab)
        }

        binding.tlResto.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val categoryId = tab?.tag as? Int
                categoryId?.let {
                    viewModel.selectCategory(it)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun updateMenuFragment(menuItems: List<MenuItem>, viewType: Int) {
        val fragment = MenuFragment.newInstance(menuItems, viewType)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}