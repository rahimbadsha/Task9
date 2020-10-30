package com.abdur.task9MVP.feature.foodlist.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.food_item_list.view.*

class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val iv_food = itemView.iv_foodlist
    val tv_name = itemView.tv_foodlist_name
    val tv_price = itemView.tv_foodlist_price_value
    val iv_favorite = itemView.iv_foodlist_favorite
}