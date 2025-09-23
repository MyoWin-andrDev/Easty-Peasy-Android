package com.myowin.eastypeasy.view.adapter.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myowin.eastypeasy.databinding.ListItemCartBinding
import com.myowin.eastypeasy.model.dto.MenuItem

class CartAdapter(val cartList : List<MenuItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    inner class CartViewHolder(private val binding : ListItemCartBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cartItem : MenuItem) = with(binding){
           // tvTitleRestaurant.text = cartItem.
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder
        = CartViewHolder(ListItemCartBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = cartList.size

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {
        holder.bind(cartList[position])
    }




}