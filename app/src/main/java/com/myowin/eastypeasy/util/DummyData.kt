package com.myowin.eastypeasy.util

import com.myowin.eastypeasy.model.dto.MenuCategory
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.model.dto.RestaurantModel


// Test restaurant with mixed view types
val testRestaurant = RestaurantModel(
    restaurantId = 1,
    restaurantName = "The Collective Pattaya",
    isFav = true,
    restaurantImage = "https://picsum.photos/seed/resto1/400/300",
    status = true,
    rating = 4.5f,
    address = "463/68 Beachfront, Pattaya",
    specialty = "Seafood & International",
    distance = 2.3f,
    menuCategories = listOf(
        // Grid view category
        MenuCategory(
            id = 1,
            name = "Main Dishes",
            viewType = 1,
            menuItemList = listOf(
                MenuItem(
                    id = 101,
                    name = "Grilled Salmon",
                    imageUrl = "https://picsum.photos/seed/salmon/200/200",
                    description = "Fresh salmon grilled with herbs and lemon",
                    amount = 18.99f,
                    availability = true,
                    noteToRestaurant = "No spices please"
                ),
                MenuItem(
                    id = 102,
                    name = "Beef Steak",
                    imageUrl = "https://picsum.photos/seed/steak/200/200",
                    description = "Tender beef steak with mushroom sauce",
                    amount = 22.50f,
                    availability = true,
                    noteToRestaurant = "Medium rare"
                ),
                MenuItem(
                    id = 103,
                    name = "Chicken Parmesan",
                    imageUrl = "https://picsum.photos/seed/chicken/200/200",
                    description = "Breaded chicken with tomato sauce and cheese",
                    amount = 16.75f,
                    availability = true
                ),
                MenuItem(
                    id = 104,
                    name = "Vegetable Pasta",
                    imageUrl = "https://picsum.photos/seed/pasta/200/200",
                    description = "Fresh pasta with seasonal vegetables",
                    amount = 14.99f,
                    availability = true
                )
            )
        ),
        // List view category
        MenuCategory(
            id = 2,
            name = "Drinks",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 201,
                    name = "Fresh Orange Juice",
                    imageUrl = "https://picsum.photos/seed/orange/200/200",
                    description = "Freshly squeezed orange juice, served chilled",
                    amount = 5.99f,
                    availability = true
                ),
                MenuItem(
                    id = 202,
                    name = "Iced Coffee",
                    imageUrl = "https://picsum.photos/seed/coffee/200/200",
                    description = "Chilled coffee with cream and sugar syrup",
                    amount = 4.50f,
                    availability = true
                ),
                MenuItem(
                    id = 203,
                    name = "Mango Smoothie",
                    imageUrl = "https://picsum.photos/seed/mango/200/200",
                    description = "Blended mango with yogurt and honey",
                    amount = 6.75f,
                    availability = true
                )
            )
        ),
        // Another grid view category
        MenuCategory(
            id = 3,
            name = "Desserts",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 301,
                    name = "Chocolate Cake",
                    imageUrl = "https://picsum.photos/seed/cake/200/200",
                    description = "Rich chocolate cake with ganache frosting",
                    amount = 8.99f,
                    availability = true
                ),
                MenuItem(
                    id = 302,
                    name = "Ice Cream Sundae",
                    imageUrl = "https://picsum.photos/seed/icecream/200/200",
                    description = "Vanilla ice cream with chocolate sauce and nuts",
                    amount = 6.50f,
                    availability = true
                )
            )
        ),
        // List view category
        MenuCategory(
            id = 4,
            name = "Appetizers",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 401,
                    name = "Garlic Bread",
                    imageUrl = "https://picsum.photos/seed/garlicbread/200/200",
                    description = "Toasted bread with garlic butter and herbs",
                    amount = 4.99f,
                    availability = true
                ),
                MenuItem(
                    id = 402,
                    name = "Mozzarella Sticks",
                    imageUrl = "https://picsum.photos/seed/mozzarella/200/200",
                    description = "Breaded and fried mozzarella cheese sticks",
                    amount = 7.25f,
                    availability = true
                ),
                MenuItem(
                    id = 403,
                    name = "Chicken Wings",
                    imageUrl = "https://picsum.photos/seed/wings/200/200",
                    description = "Crispy chicken wings with buffalo sauce",
                    amount = 9.99f,
                    availability = true,
                    noteToRestaurant = "Extra spicy please"
                )
            )
        ),
        // Additional categories
        MenuCategory(
            id = 5,
            name = "Salads",
            viewType = 1,
            menuItemList = listOf(
                MenuItem(
                    id = 501,
                    name = "Caesar Salad",
                    imageUrl = "https://picsum.photos/seed/caesar/200/200",
                    description = "Fresh romaine with caesar dressing and croutons",
                    amount = 9.99f,
                    availability = true
                ),
                MenuItem(
                    id = 502,
                    name = "Greek Salad",
                    imageUrl = "https://picsum.photos/seed/greek/200/200",
                    description = "Mixed greens with feta, olives, and vinaigrette",
                    amount = 8.50f,
                    availability = true
                ),
                MenuItem(
                    id = 503,
                    name = "Thai Beef Salad",
                    imageUrl = "https://picsum.photos/seed/thaibeef/200/200",
                    description = "Spicy beef salad with herbs and lime dressing",
                    amount = 12.75f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 6,
            name = "Soups",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 601,
                    name = "Tom Yum Goong",
                    imageUrl = "https://picsum.photos/seed/tomyum/200/200",
                    description = "Spicy Thai soup with shrimp and mushrooms",
                    amount = 7.99f,
                    availability = true
                ),
                MenuItem(
                    id = 602,
                    name = "Cream of Mushroom",
                    imageUrl = "https://picsum.photos/seed/mushroom/200/200",
                    description = "Creamy mushroom soup with herbs",
                    amount = 6.50f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 7,
            name = "Seafood Specialties",
            viewType = 1,
            menuItemList = listOf(
                MenuItem(
                    id = 701,
                    name = "Grilled Prawns",
                    imageUrl = "https://picsum.photos/seed/prawns/200/200",
                    description = "Jumbo prawns grilled with garlic butter",
                    amount = 24.99f,
                    availability = true
                ),
                MenuItem(
                    id = 702,
                    name = "Steamed Mussels",
                    imageUrl = "https://picsum.photos/seed/mussels/200/200",
                    description = "Fresh mussels steamed in white wine sauce",
                    amount = 18.50f,
                    availability = true
                ),
                MenuItem(
                    id = 703,
                    name = "Fish & Chips",
                    imageUrl = "https://picsum.photos/seed/fishchips/200/200",
                    description = "Beer-battered fish with french fries",
                    amount = 15.75f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 8,
            name = "Vegetarian Options",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 801,
                    name = "Vegetable Stir Fry",
                    imageUrl = "https://picsum.photos/seed/stirfry/200/200",
                    description = "Assorted vegetables stir-fried in soy sauce",
                    amount = 13.99f,
                    availability = true
                ),
                MenuItem(
                    id = 802,
                    name = "Tofu Curry",
                    imageUrl = "https://picsum.photos/seed/tofu/200/200",
                    description = "Tofu in coconut curry with vegetables",
                    amount = 12.50f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 9,
            name = "Burgers & Sandwiches",
            viewType = 1,
            menuItemList = listOf(
                MenuItem(
                    id = 901,
                    name = "Classic Burger",
                    imageUrl = "https://picsum.photos/seed/burger/200/200",
                    description = "Beef patty with lettuce, tomato, and cheese",
                    amount = 14.99f,
                    availability = true
                ),
                MenuItem(
                    id = 902,
                    name = "Chicken Club Sandwich",
                    imageUrl = "https://picsum.photos/seed/club/200/200",
                    description = "Grilled chicken with bacon and avocado",
                    amount = 13.50f,
                    availability = true
                ),
                MenuItem(
                    id = 903,
                    name = "Veggie Wrap",
                    imageUrl = "https://picsum.photos/seed/wrap/200/200",
                    description = "Fresh vegetables in whole wheat wrap",
                    amount = 10.75f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 10,
            name = "Asian Noodles",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 1001,
                    name = "Pad Thai",
                    imageUrl = "https://picsum.photos/seed/padthai/200/200",
                    description = "Stir-fried rice noodles with shrimp and peanuts",
                    amount = 16.99f,
                    availability = true
                ),
                MenuItem(
                    id = 1002,
                    name = "Ramen Noodles",
                    imageUrl = "https://picsum.photos/seed/ramen/200/200",
                    description = "Japanese noodle soup with pork and egg",
                    amount = 15.50f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 11,
            name = "Rice Dishes",
            viewType = 1,
            menuItemList = listOf(
                MenuItem(
                    id = 1101,
                    name = "Fried Rice",
                    imageUrl = "https://picsum.photos/seed/friedrice/200/200",
                    description = "Stir-fried rice with vegetables and egg",
                    amount = 12.99f,
                    availability = true
                ),
                MenuItem(
                    id = 1102,
                    name = "Chicken Biryani",
                    imageUrl = "https://picsum.photos/seed/biryani/200/200",
                    description = "Fragrant rice with spiced chicken",
                    amount = 17.50f,
                    availability = true
                ),
                MenuItem(
                    id = 1103,
                    name = "Seafood Paella",
                    imageUrl = "https://picsum.photos/seed/paella/200/200",
                    description = "Spanish rice dish with assorted seafood",
                    amount = 21.75f,
                    availability = true
                )
            )
        ),
        MenuCategory(
            id = 12,
            name = "Breakfast",
            viewType = 2,
            menuItemList = listOf(
                MenuItem(
                    id = 1201,
                    name = "English Breakfast",
                    imageUrl = "https://picsum.photos/seed/english/200/200",
                    description = "Eggs, bacon, sausage, beans, and toast",
                    amount = 14.99f,
                    availability = true
                ),
                MenuItem(
                    id = 1202,
                    name = "Pancakes",
                    imageUrl = "https://picsum.photos/seed/pancakes/200/200",
                    description = "Fluffy pancakes with maple syrup",
                    amount = 9.50f,
                    availability = true
                )
            )
        )
    )
)