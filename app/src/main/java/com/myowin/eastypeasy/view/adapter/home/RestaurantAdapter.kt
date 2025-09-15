package com.myowin.eastypeasy.view.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myowin.eastypeasy.databinding.ListItemRestaurantBinding
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.util.loadImageFromResource

class RestaurantAdapter (val restaurantList : List<RestaurantModel>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantViewHolder =
        RestaurantViewHolder(ListItemRestaurantBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(
        holder: RestaurantViewHolder,
        position: Int
    ) {
       holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int  = restaurantList.size

    inner class RestaurantViewHolder(private val binding : ListItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(restaurant: RestaurantModel) = with(binding){
            itemView.context.loadImageFromResource(restaurant.restaurantImage, ivRestaurantImage)
            tvRestaurantName.text = restaurant.restaurantName
            tvSpecialty.text = restaurant.specialty
            tvRating.text = restaurant.rating.toString()
            tvDuration.text = "${restaurant.distance} mins"
        }
    }
}