package com.myowin.eastypeasy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myowin.eastypeasy.data.local.DataStoreManager
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val repository: HomeRepository,
) : ViewModel() {

    val restaurants = MutableStateFlow<List<RestaurantModel>>(emptyList())

    fun loadRestaurants() {
        viewModelScope.launch {
            val result = repository.fetchRestaurants()
            result.onSuccess { data ->
                restaurants.value = data
            }.onFailure { error ->
                // handle error
            }
        }
    }
}
