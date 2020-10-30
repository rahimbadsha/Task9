package com.abdur.task9MVP.feature.foodlist.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Food (
    val id: Int,
    val name: String,
    val price: Int,
    val isFavorite: Boolean,
    val imageUrl: String,
    val rating: Float,
    val description: String,
    @SerializedName("restaurantName") val restaurant: String
): Serializable