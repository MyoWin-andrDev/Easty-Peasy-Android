package com.myowin.eastypeasy.repository.restaurant_detail

import com.myowin.eastypeasy.model.dto.RestaurantModel

interface RestoDetailRepository{
    suspend fun fetchRestaurantDetail(restaurantId : Int) : Result<RestaurantModel>
}