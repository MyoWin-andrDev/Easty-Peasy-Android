package com.myowin.eastypeasy.viewmodel

import androidx.lifecycle.ViewModel
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.view.adapter.restaurant_detail.MenuAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
) : ViewModel() {

    private val _restaurant = MutableStateFlow<RestaurantModel?>(null)
    val restaurant: StateFlow<RestaurantModel?> = _restaurant.asStateFlow()

    private val _menuItem = MutableStateFlow<List<MenuItem>>(emptyList())
    val menuItem: StateFlow<List<MenuItem>> = _menuItem.asStateFlow()

    private val _currentViewType = MutableStateFlow(MenuAdapter.VIEW_TYPE_GRID)
    val currentViewType: StateFlow<Int> = _currentViewType.asStateFlow()

    fun setRestaurant(restaurant: RestaurantModel) {
        _restaurant.value = restaurant
        Timber.d("Restaurant set: ${restaurant.restaurantName}")
    }

    fun selectCategory(categoryId: Int) {
        _restaurant.value?.menuCategories
            ?.find { it.id == categoryId }
            ?.let { category ->
                _menuItem.value = category.menuItemList
                _currentViewType.value = category.viewType
                Timber.d("Category selected: ${category.name}")
            }
    }
}