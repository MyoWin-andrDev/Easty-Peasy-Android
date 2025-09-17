package com.myowin.eastypeasy.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class RestaurantModel(
    val restaurantId: String = "",
    val restaurantName : String = "",
    val isFav: Boolean = false,
    val restaurantImage: String = "",
    val status: Boolean = true,
    val rating: Float = 0.0f,
    val address: String = "",
    val specialty: String = "",
    val distance: Float = 0.0f,
    val delivery : String = ""
)