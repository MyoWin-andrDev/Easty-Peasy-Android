package com.myowin.eastypeasy.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.repository.restaurant.RestaurantRepository
import com.myowin.eastypeasy.util.testRestaurant
import com.myowin.eastypeasy.view.adapter.restaurant_detail.MenuAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val repository: RestaurantRepository
)  : ViewModel() {

    private val _restaurant = MutableStateFlow<RestaurantModel?>(null)
    val restaurant : StateFlow<RestaurantModel?> = _restaurant

    private val _category = MutableStateFlow<List<MenuItem>>(emptyList())
    val category : StateFlow<List<MenuItem>> = _category

    private val _currentViewType = MutableStateFlow(MenuAdapter.VIEW_TYPE_GRID)
    val currentViewType: StateFlow<Int> = _currentViewType

    fun setRestaurant(restaurant: RestaurantModel) {
        _restaurant.value = restaurant
        restaurant.menuCategories.firstOrNull()?.let { category ->
            _category.value = category.menuItemList
            _currentViewType.value = category.viewType
        }
        Log.d("RestaurantViewModel", "Restaurant set: ${restaurant.restaurantName}")
    }

    fun selectCategory(categoryId: Int) {
        restaurant.value?.menuCategories?.find { it.id == categoryId }?.let { category ->
            _category.value = category.menuItemList
            _currentViewType.value = category.viewType
            Log.d("RestaurantViewModel", "Selected category: $categoryId")
        }
    }


}