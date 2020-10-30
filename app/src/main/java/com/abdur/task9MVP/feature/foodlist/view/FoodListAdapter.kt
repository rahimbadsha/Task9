package com.abdur.task9MVP.feature.foodlist.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdur.task9MVP.feature.foodlist.model.Food
import com.bumptech.glide.Glide
import com.example.task9.R

class FoodListAdapter(
    private val foodList: MutableList<Food>,
    private val clickListener: ItemClickListener
): RecyclerView.Adapter<FoodViewHolder>() {

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.food_item_list, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        val food = foodList[position]

        Glide.with(context)
            .load(food.imageUrl)
            .centerCrop()
            .error(R.drawable.error)
            .into(holder.iv_food)

        holder.tv_name.text = food.name
        holder.tv_price.text = holder.itemView.context.getString(R.string.price_format, food.price)

        holder.itemView.setOnClickListener {
            clickListener.onItemClickListener(position)
        }
    }
}