package com.myowin.eastypeasy.view.adapter.restaurant_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myowin.eastypeasy.databinding.ListItemDishesBinding
import com.myowin.eastypeasy.model.uimodel.resto_detail.MenuEntity
import com.myowin.eastypeasy.util.loadImageFromResource

class DishesAdapter(val dishesList : List<MenuEntity>) : RecyclerView.Adapter<DishesAdapter.DishesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DishesViewHolder =
        DishesViewHolder(ListItemDishesBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(
        holder: DishesViewHolder,
        position: Int
    ) {
        holder.bind(dishesList[position])
    }

    override fun getItemCount(): Int = dishesList.size

    inner class DishesViewHolder(private val binding : ListItemDishesBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(dishesItem : MenuEntity) = with(binding){
            itemView.context.loadImageFromResource(dishesItem.image, ivDishes)
            tvName.text = dishesItem.name
            tvDescription.text = dishesItem.description
            tvPrice.text = "$ ${dishesItem.price}"
        }
    }
}