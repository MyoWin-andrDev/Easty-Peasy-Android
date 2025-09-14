package com.myowin.eastypeasy.view.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myowin.eastypeasy.databinding.ListItemCuisineBinding
import com.myowin.eastypeasy.model.uimodel.home.CuisineModel
import com.myowin.eastypeasy.util.loadImageFromResource

class CuisineAdapter(val cuisineList : List<CuisineModel>) : RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CuisineViewHolder =
        CuisineViewHolder(ListItemCuisineBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(
        holder: CuisineViewHolder,
        position: Int
    ) {
        holder.bind(cuisineList[position])
    }

    override fun getItemCount(): Int = cuisineList.size

    inner class CuisineViewHolder(val binding : ListItemCuisineBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (cuisineItem : CuisineModel) = with(binding){
            itemView.context.loadImageFromResource(cuisineItem.img, ivCuisine)
            tvName.text = cuisineItem.name
        }
    }
}