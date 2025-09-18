package com.myowin.eastypeasy.view.adapter.restaurant_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myowin.eastypeasy.databinding.ItemMenuListBinding
import com.myowin.eastypeasy.databinding.ItemMenuGridBinding
import com.myowin.eastypeasy.model.dto.MenuItem

class MenuAdapter(
    private val menuItems: List<MenuItem>,
    private val viewType: Int = VIEW_TYPE_GRID // Default to grid
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_GRID = 1
        const val VIEW_TYPE_LIST = 2
    }

    // Two different ViewHolders for different layouts
    class GridViewHolder(val binding: ItemMenuGridBinding) : RecyclerView.ViewHolder(binding.root)
    class ListViewHolder(val binding: ItemMenuListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LIST -> {
                val binding = ItemMenuListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ListViewHolder(binding)
            }
            else -> {
                val binding = ItemMenuGridBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                GridViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = menuItems[position]

        when (holder) {
            is GridViewHolder -> {
                // Bind to grid layout
                holder.binding.tvName.text = item.name
                holder.binding.tvPrice.text = "$${item.amount}"
                // Load image etc.
            }
            is ListViewHolder -> {
                // Bind to list layout
                holder.binding.tvName.text = item.name
                holder.binding.tvDescription.text = item.description
                holder.binding.tvPrice.text = "$${item.amount}"
                // Load image etc.
            }
        }
    }

    override fun getItemCount() = menuItems.size
}