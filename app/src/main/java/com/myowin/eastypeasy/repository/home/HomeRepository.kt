package com.myowin.eastypeasy.repository.home

import com.myowin.eastypeasy.model.dto.RestaurantModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    val isFirstLaunchFlow: Flow<Boolean>
    suspend fun finishFirstLaunch()
    suspend fun fetchRestaurants(): Result<List<RestaurantModel>>

    // You can add more Home-related functions here
    // e.g., fetchHomeData(), getUserProfile(), etc.
}
