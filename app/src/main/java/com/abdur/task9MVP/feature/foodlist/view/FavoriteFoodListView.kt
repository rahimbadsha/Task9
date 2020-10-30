package com.abdur.task9MVP.feature.foodlist.view

import com.abdur.task9MVP.feature.foodlist.model.Food

interface FavoriteFoodListView {

    fun onFavoriteFoodListFetchSuccess(favoriteFoodList: MutableList<Food>)
    fun onFavoriteFoodListFetchFailure(errorMessage: String)
    fun handleFavoriteProgressBarVisibility(visibility: Int)
}