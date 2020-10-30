package com.abdur.task9MVP.feature.foodlist.model

interface FavoriteFoodListCallback {

    fun onSuccess(foodList: MutableList<Food>)
    fun onError(throwable: Throwable)

}