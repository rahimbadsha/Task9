package com.abdur.task9MVP.network

import com.abdur.task9MVP.feature.foodlist.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("rahimbadsha/Task6/master/app/food_json.json")
    fun getFavoriteItemFoodList(): Call<MutableList<Food>>
}