package com.abdur.task9MVP.feature.foodlist.presenter

import android.view.View
import com.abdur.task9MVP.feature.foodlist.model.FavoriteFoodListCallback
import com.abdur.task9MVP.feature.foodlist.model.FavoriteFoodListModel
import com.abdur.task9MVP.feature.foodlist.model.FavoriteFoodListModelImpl
import com.abdur.task9MVP.feature.foodlist.model.Food
import com.abdur.task9MVP.feature.foodlist.view.FavoriteFoodListView

class FavoriteFoodListPresenterImpl(
    private val view: FavoriteFoodListView
): FavoriteFoodListPresenter {

    private val favoriteFoodModel: FavoriteFoodListModel =
        FavoriteFoodListModelImpl()
    private val VISIBLE = 0 // View.Visible = 0
    private val GONE = 8 // View.GONE = 8

    override fun getFovoriteFoodList() {

        view.handleFavoriteProgressBarVisibility(View.VISIBLE)

        favoriteFoodModel.getFavoriteFoodList(object : FavoriteFoodListCallback{
            override fun onSuccess(foodList: MutableList<Food>) {
                view.handleFavoriteProgressBarVisibility(View.GONE)
                view.onFavoriteFoodListFetchSuccess(foodList)
            }

            override fun onError(throwable: Throwable) {
                view.handleFavoriteProgressBarVisibility(View.GONE)
                view.onFavoriteFoodListFetchFailure(throwable.localizedMessage!!)
            }

        })
    }
}