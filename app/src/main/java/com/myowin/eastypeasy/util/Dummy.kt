package com.myowin.eastypeasy.util

import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.model.uimodel.home.CuisineModel
import com.myowin.eastypeasy.model.uimodel.home.RestaurantModel
import com.myowin.eastypeasy.model.uimodel.resto_detail.MenuEntity

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

// List of 10 test dishes
val testDishes = listOf(
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 12.99f,
        name = "Thai Red Curry",
        description = "Sweet and spicy coconut curry with vegetables"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 11.50f,
        name = "Pad Thai",
        description = "Stir-fried rice noodles with eggs and tofu"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 13.75f,
        name = "Green Curry",
        description = "Spicy green curry with bamboo shoots and basil"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 14.25f,
        name = "Massaman Curry",
        description = "Rich peanut curry with potatoes and onions"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 9.99f,
        name = "Tom Yum Soup",
        description = "Hot and sour soup with lemongrass and mushrooms"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 8.50f,
        name = "Chicken Satay",
        description = "Grilled chicken skewers with peanut sauce"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 10.75f,
        name = "Pineapple Fried Rice",
        description = "Fried rice served in a pineapple boat"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 7.99f,
        name = "Mango Sticky Rice",
        description = "Sweet dessert with coconut milk and fresh mango"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 6.50f,
        name = "Fresh Spring Rolls",
        description = "Rice paper rolls with vegetables and herbs"
    ),
    MenuEntity(
        image = R.drawable.thai_red_curry,
        price = 4.99f,
        name = "Thai Iced Tea",
        description = "Sweet creamy orange-colored tea"
    )
)

// List of 10 test drinks
val testDrinks = listOf(
    MenuEntity(
        image = R.drawable.coffee,
        price = 4.99f,
        name = "Coffee Frappe",
        description = "Iced coffee blended with milk and ice"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 5.50f,
        name = "Cappuccino",
        description = "Espresso with steamed milk and foam"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 5.25f,
        name = "Latte",
        description = "Espresso with steamed milk"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 6.75f,
        name = "Mocha",
        description = "Chocolate-flavored coffee with whipped cream"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 3.99f,
        name = "Espresso",
        description = "Strong black coffee shot"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 5.95f,
        name = "Caramel Macchiato",
        description = "Vanilla syrup with caramel drizzle"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 4.50f,
        name = "Americano",
        description = "Espresso with hot water"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 6.25f,
        name = "Iced Vanilla Latte",
        description = "Cold latte with vanilla flavor"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 7.50f,
        name = "Matcha Latte",
        description = "Green tea powder with steamed milk"
    ),
    MenuEntity(
        image = R.drawable.coffee,
        price = 5.99f,
        name = "Hot Chocolate",
        description = "Rich chocolate drink with whipped cream"
    )
)

val testCakes = listOf(
    MenuEntity(
        image = R.drawable.chocolate,
        price = 6.50f,
        name = "Chocolate Fudge Cake",
        description = "Rich chocolate cake with creamy fudge frosting"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 7.25f,
        name = "Red Velvet Cake",
        description = "Moist red velvet with cream cheese icing"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 6.75f,
        name = "Black Forest Cake",
        description = "Chocolate cake with cherries and whipped cream"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 5.99f,
        name = "Carrot Cake",
        description = "Spiced carrot cake with walnuts and cream cheese frosting"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 8.50f,
        name = "Tiramisu",
        description = "Coffee-soaked sponge with mascarpone cream"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 7.50f,
        name = "Cheesecake",
        description = "Creamy cheesecake with a graham cracker crust"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 6.25f,
        name = "Lemon Drizzle Cake",
        description = "Tangy lemon cake with a sweet glaze"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 7.75f,
        name = "Vanilla Sponge Cake",
        description = "Light vanilla cake with buttercream frosting"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 8.25f,
        name = "Salted Caramel Cake",
        description = "Caramel-infused cake with sea salt topping"
    ),
    MenuEntity(
        image = R.drawable.chocolate,
        price = 6.99f,
        name = "Strawberry Shortcake",
        description = "Fluffy cake with fresh strawberries and cream"
    )
)


