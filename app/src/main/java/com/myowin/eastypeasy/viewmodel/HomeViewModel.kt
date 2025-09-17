package com.myowin.eastypeasy.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myowin.eastypeasy.data.local.DataStoreManager
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val repository: HomeRepository,
) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<RestaurantModel>>(emptyList())
    val restaurants : StateFlow<List<RestaurantModel>> = _restaurants

    fun loadRestaurants() {
        viewModelScope.launch {
            val result = repository.fetchRestaurants()
            result.onSuccess { data ->
                _restaurants.value = data
            }.onFailure { error ->
                // handle error
                Timber.e(error, "Failed to fetch restaurants")
            }
        }
    }
}
