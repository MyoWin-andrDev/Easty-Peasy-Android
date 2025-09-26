package com.myowin.eastypeasy.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class RestaurantModel(
    val restaurantId: Int = 0,
    val restaurantName : String = "",
    val isFav: Boolean = false,
    val restaurantImage: String = "",
    val status: Boolean = true,
    val rating: Float = 0.0f,
    val address: String = "",
    val specialty: String = "",
    val duration: Float = 0.0f,
    val delivery : String = "",
    val menuCategories: List<MenuCategory> = emptyList<MenuCategory>()
) : Parcelable

@Parcelize
@Serializable
data class MenuCategory(
    val id : Int = 0,
    val name : String = "",
    val viewType : Int = 1,
    val menuItemList : List<MenuItem> = emptyList<MenuItem>()
) : Parcelable

@Parcelize
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
) : Parcelable

@Parcelize
@Serializable
data class MandatoryOption(
    val id : Int = 0,
    val title : String = "",
    val itemList : List<MandatoryItem> = emptyList()
) : Parcelable

@Parcelize
@Serializable
data class MandatoryItem(
    val id : Int = 0,
    val title : String = "",
    val amount : Float = 0.0f,
    val isSelected : Boolean = false
) : Parcelable

@Parcelize
@Serializable
data class AddOnOption(
    val id : Int = 0,
    val title : String = "",
    val itemList : List<AddonItem> = emptyList()
) : Parcelable

@Parcelize
@Serializable
data class AddonItem(
    val id : Int = 0,
    val title : String = "",
    val amount : Float = 0.0f,
    var isSelected : Boolean = false
) : Parcelable

@Parcelize
data class OrderItem(
    val id : Int = 0,
    val quantity : Int = 0,
    val subTotal : Float = 0.0f,
    val addOnItem : List<AddonItem> = emptyList(),
    val note : String = ""
) : Parcelable