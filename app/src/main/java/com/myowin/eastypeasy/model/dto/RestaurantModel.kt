package com.myowin.eastypeasy.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class RestaurantModel(
    val restaurantName: String = "",
    val isFav: Boolean = false,
)