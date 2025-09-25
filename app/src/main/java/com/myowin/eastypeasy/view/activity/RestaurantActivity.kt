package com.myowin.eastypeasy.view.activity

import android.os.Bundle
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
import com.myowin.eastypeasy.util.loadBackgroundFromUrl
import com.myowin.eastypeasy.view.fragment.restaurant_detail.MenuFragment
import com.myowin.eastypeasy.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private companion object {
        const val RESTAURANT_EXTRA_KEY = "RESTAURANT_PARCELABLE"
    }

    private val binding: ActivityRestaurantBinding by viewBinding()
    private val viewModel: RestaurantViewModel by viewModels()

    private val restaurant: RestaurantModel? by lazy {
        intent.getParcelableExtra(RESTAURANT_EXTRA_KEY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeActivity()
    }

    private fun initializeActivity() {
        validateRestaurantData()
        setRestaurant()
        setupObservers()
    }

    private fun validateRestaurantData() {
        if (restaurant == null) {
            Timber.e("Restaurant data is null, finishing activity")
            finish()
            return
        }
    }

    private fun setRestaurant() {
        setupClickListeners()
        restaurant?.let { viewModel.setRestaurant(it) }
    }

    private fun setupClickListeners() {
        with(binding) {
            ivBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
            ivCart.setOnClickListener { handleCartClick() }
        }
    }

    private fun setupObservers() {
        observeRestaurantData()
        observeMenuItems()
    }

    private fun observeRestaurantData() {
        lifecycleScope.launch {
            viewModel.restaurant.collectLatest { restaurant ->
                restaurant?.let {
                    updateRestaurantUI(it)
                    setupCategoryTabs(it.menuCategories)
                    selectFirstCategory(it.menuCategories)
                }
            }
        }
    }

    private fun observeMenuItems() {
        lifecycleScope.launch {
            viewModel.menuItem.collectLatest { menuItems ->
                updateMenuFragment(menuItems, viewModel.currentViewType.value)
            }
        }
    }

    private fun updateRestaurantUI(restaurant: RestaurantModel) {
        with(binding) {
            tvRestoName.text = restaurant.restaurantName
            tvRestaurantAddress.text = restaurant.address
            tvRating.text = restaurant.rating.toString()
            tvDuration.text = restaurant.duration.toString()

            loadRestaurantImage(restaurant.restaurantImage)
        }
    }

    private fun loadRestaurantImage(imageUrl: String?) {
        imageUrl?.let {
            loadBackgroundFromUrl(it, binding.clHeroImage)
        }
    }

    private fun setupCategoryTabs(categories: List<MenuCategory>) {
        with(binding.tlResto) {
            removeAllTabs()
            categories.forEach { category -> addCategoryTab(category) }
            addOnTabSelectedListener(createTabSelectionListener())
        }
    }

    private fun TabLayout.addCategoryTab(category: MenuCategory) {
        val tab = newTab().apply {
            text = category.name
            tag = category.id
        }
        addTab(tab)
    }

    private fun createTabSelectionListener(): TabLayout.OnTabSelectedListener {
        return object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.tag?.let { categoryId ->
                    viewModel.selectCategory(categoryId as Int)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        }
    }

    private fun selectFirstCategory(categories: List<MenuCategory>) {
        categories.firstOrNull()?.let { category ->
            viewModel.selectCategory(category.id)
        }
    }

    private fun updateMenuFragment(
        menuItems: List<MenuItem>,
        viewType: Int
    ) {
        val fragment = MenuFragment.newInstance(menuItems, viewType)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun handleCartClick() {
        // TODO: Implement cart navigation logic
        Timber.d("Cart icon clicked")
    }
}