package com.abdur.task9MVP.feature.foodlist.model

import com.abdur.task9MVP.network.FoodApiInterface
import com.abdur.task9MVP.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class FavoriteFoodListModelImpl: FavoriteFoodListModel {

    private val apiInterface = RetrofitClient.getClient().create(FoodApiInterface::class.java)
    private val call = apiInterface.getFavoriteItemFoodList()

    override fun getFavoriteFoodList(favoriteFoodListCallback: FavoriteFoodListCallback) {

        call.enqueue(object : Callback<MutableList<Food>>{
            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
                favoriteFoodListCallback.onError(t)
            }

            override fun onResponse(call: Call<MutableList<Food>>, response: Response<MutableList<Food>>) {
                response.body()?.let {
                    favoriteFoodListCallback.onSuccess(it)
                }
            }
        })
    }
}

