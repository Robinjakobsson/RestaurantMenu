package com.example.wildwest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DishAdapter(private var dishes: List<Dish>) : RecyclerView.Adapter<DishAdapter.DishViewHolder>() {


    inner class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dishImage: ImageView = itemView.findViewById(R.id.dishImage)
        val dishName: TextView = itemView.findViewById(R.id.dishName)
        val dishDescription: TextView = itemView.findViewById(R.id.dishDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent,false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val dish = dishes[position]
        holder.dishImage.setImageResource(dish.imageResId)
        holder.dishName.text = dish.name
        holder.dishDescription.text = dish.description
    }

    override fun getItemCount() = dishes.size

    fun updateDishes(newDishes: List<Dish>) {
        dishes = newDishes
        notifyDataSetChanged()
    }
}