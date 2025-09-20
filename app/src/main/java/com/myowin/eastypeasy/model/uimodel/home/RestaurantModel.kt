package com.myowin.eastypeasy.model.uimodel.home

data class RestaurantModel(
    val restaurantName: String = "",
    val isFav: Boolean = false,
    val restaurantImage:  Int = 0,        // Image URL or resource reference
    val status: Boolean = true,                 // Open / Closed
    val rating: Float = 0.0f,                  // 4.9
    val address: String = "",                // Address
    val specialty: String = "",              // Seafood - Curry - Cocktails
    val distance: Float = 0.0f      // Location or distance information
)