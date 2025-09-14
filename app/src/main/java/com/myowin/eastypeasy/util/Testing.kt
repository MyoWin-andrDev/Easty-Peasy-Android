package com.myowin.eastypeasy.util

import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.model.uimodel.home.CuisineModel
import com.myowin.eastypeasy.model.uimodel.home.RestaurantModel

// Create test data
val testRestaurantList = listOf(
    RestaurantModel(
        restaurantImage = R.drawable.the_collective_pattaya,
        restaurantName = "Italian Bistro",
        specialty = "Pasta & Pizza",
        rating = 4.5f,
        distance = 1.2f
    ),
    RestaurantModel(
        restaurantImage = R.drawable.the_collective_pattaya,
        restaurantName = "Sushi Palace",
        specialty = "Japanese Cuisine",
        rating = 4.8f,
        distance = 2.5f
    ),
    // Add more test items as needed
)
val testingCuisineList = listOf(
    CuisineModel(
        img = R.drawable.cuisine,
        name = "Noodle"
    ),
    CuisineModel(
        img = R.drawable.american_breakfast,
        name = "Coffee"
    ),
    CuisineModel(
        img = R.drawable.cuisine,
        name = "Noodle"
    ),
    CuisineModel(
        img = R.drawable.american_breakfast,
        name = "Coffee"
    ),
    CuisineModel(
        img = R.drawable.cuisine,
        name = "Noodle"
    ),
    CuisineModel(
        img = R.drawable.american_breakfast,
        name = "Coffee"
    ),
    CuisineModel(
        img = R.drawable.cuisine,
        name = "Noodle"
    ),
    CuisineModel(
        img = R.drawable.american_breakfast,
        name = "Coffee"
    ),
    CuisineModel(
        img = R.drawable.cuisine,
        name = "Noodle"
    ),
    CuisineModel(
        img = R.drawable.american_breakfast,
        name = "Coffee"
    )
)