package com.myowin.eastypeasy.view.adapter.restaurant_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myowin.eastypeasy.databinding.ListItemMenuBinding
import com.myowin.eastypeasy.model.uimodel.resto_detail.MenuEntity
import com.myowin.eastypeasy.util.loadImageFromResource

class MenuAdapter(val drinksList : List<MenuEntity>) : RecyclerView.Adapter<MenuAdapter.DrinksViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DrinksViewHolder =
        DrinksViewHolder(ListItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(
        holder: DrinksViewHolder,
        position: Int
    ) {
        holder.bind(drinksList[position])
    }

    override fun getItemCount(): Int = drinksList.size

    inner class DrinksViewHolder(private val binding : ListItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(drinksItem : MenuEntity) = with(binding){
            itemView.context.loadImageFromResource(drinksItem.image, ivDrinks)
            tvName.text = drinksItem.name
            tvDescription.text = drinksItem.description
            tvPrice.text = "$ ${drinksItem.price}"
        }
    }
}