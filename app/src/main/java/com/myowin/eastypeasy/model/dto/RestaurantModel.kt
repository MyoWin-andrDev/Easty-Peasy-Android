package com.myowin.eastypeasy.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class RestaurantModel(
    val restaurantId: Int = 0 ,
    val restaurantName : String = "",
    val isFav: Boolean = false,
    val restaurantImage: String = "",
    val status: Boolean = true,
    val rating: Float = 0.0f,
    val address: String = "",
    val specialty: String = "",
    val distance: Float = 0.0f,
    val delivery : String = "",
    val menuCategories: List<MenuCategory> = emptyList<MenuCategory>()
)

@Serializable
data class MenuCategory(
    val id : Int = 0,
    val name : String = "",
    val viewType : Int = 1,
    val menuItemList : List<MenuItem> = emptyList<MenuItem>()
)

@Serializable
data class MenuItem(
    val id : Int = 0,
    val name : String = "",
    val imageUrl : String = "",
    val description : String = "",
    val amount : Float = 0.0f,
    val availability : Boolean = true,
    val noteToRestaurant : String = "",
    val mandatoryOption : List<MandatoryOption> = emptyList<MandatoryOption>(),
    val addOnOption : List<AddOnOption> = emptyList()
)

@Serializable
data class MandatoryOption(
    val id : Int = 0,
    val title : String = "",
    val itemList : List<MandatoryItem> = emptyList()
)

@Serializable
data class MandatoryItem(
    val id : Int = 0,
    val title : String = "",
    val amount : Float = 0.0f,
    val isSelected : Boolean = false
)

@Serializable
data class AddOnOption(
    val id : Int = 0,
    val title : String = "",
    val itemList : List<AddonItem> = emptyList()
)

@Serializable
data class AddonItem(
    val id : Int = 0,
    val title : String = "",
    val amount : Float = 0.0f,
    val isSelected : Boolean = false
)