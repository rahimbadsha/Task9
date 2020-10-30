package com.abdur.task9MVP.feature.foodlist.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdur.task9MVP.core.BaseActivity
import com.abdur.task9MVP.feature.foodlist.model.Food
import com.abdur.task9MVP.feature.foodlist.presenter.FavoriteFoodListPresenter
import com.abdur.task9MVP.feature.foodlist.presenter.FavoriteFoodListPresenterImpl
import com.example.task9.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(), FavoriteFoodListView {

    override fun setLayoutId(): Int = R.layout.activity_main

    override fun setToolbar(): Toolbar {
        foodlist_toolbar.title = getString(R.string.app_name)
        return foodlist_toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = false

    private lateinit var favoriteFoodPresenter: FavoriteFoodListPresenter

    override fun onFavoriteFoodListFetchSuccess(favoriteFoodList: MutableList<Food>) {
        initFavoriteFoodAdapter(favoriteFoodList)
    }

    override fun onFavoriteFoodListFetchFailure(errorMessage: String) {
        showTost(errorMessage)
    }

    override fun handleFavoriteProgressBarVisibility(visibility: Int) {
        foodlist_progressbar.visibility = visibility
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteFoodPresenter = FavoriteFoodListPresenterImpl(this)
        favoriteFoodPresenter.getFovoriteFoodList()
    }


    @SuppressLint("WrongConstant")
    private fun initFavoriteFoodAdapter(favoriteFoodList: MutableList<Food>) {

        val favoriteAdapter = FoodListAdapter(favoriteFoodList, object : ItemClickListener{
            override fun onItemClickListener(position: Int) {
                showTost(favoriteFoodList[position].name)
            }
        })

        foodlist_recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        foodlist_recyclerView.adapter = favoriteAdapter

    }

}
