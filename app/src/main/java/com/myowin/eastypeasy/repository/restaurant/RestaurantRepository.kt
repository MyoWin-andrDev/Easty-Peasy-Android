package com.myowin.eastypeasy.repository.restaurant

import com.myowin.eastypeasy.model.dto.RestaurantModel

interface RestaurantRepository{
    suspend fun fetchRestaurantDetail(restaurantId : Int) : Result<RestaurantModel>
}