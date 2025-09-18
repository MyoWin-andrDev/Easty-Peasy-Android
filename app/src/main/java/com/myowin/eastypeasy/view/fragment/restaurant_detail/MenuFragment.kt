package com.myowin.eastypeasy.view.fragment.restaurant_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.FragmentMenuBinding
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.view.adapter.restaurant_detail.MenuAdapter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MenuFragment : Fragment(R.layout.fragment_menu) {

    companion object {
        private const val ARG_MENU_ITEMS = "menu_items"
        private const val ARG_VIEW_TYPE = "view_type"

        fun newInstance(menuItems: List<MenuItem>, viewType: Int = MenuAdapter.VIEW_TYPE_GRID): MenuFragment {
            return MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MENU_ITEMS, Json.encodeToString(menuItems))
                    putInt(ARG_VIEW_TYPE, viewType)
                }
            }
        }
    }

    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        val menuItemsJson = arguments?.getString(ARG_MENU_ITEMS).orEmpty()
        val menuItems = try {
            Json.decodeFromString<List<MenuItem>>(menuItemsJson)
        } catch (e: Exception) {
            emptyList()
        }
        val viewType = arguments?.getInt(ARG_VIEW_TYPE, MenuAdapter.VIEW_TYPE_GRID) ?: MenuAdapter.VIEW_TYPE_GRID

        setupRecyclerView(menuItems, viewType)
    }

    private fun setupRecyclerView(menuItems: List<MenuItem>, viewType: Int) {
        // Set layout manager based on viewType
        binding.rvMenu.layoutManager = when (viewType) {
            MenuAdapter.VIEW_TYPE_LIST -> LinearLayoutManager(requireContext())
            else -> GridLayoutManager(requireContext(), 2) // Default to grid
        }

        // Use your MenuAdapter - it handles both view types internally!
        binding.rvMenu.adapter = MenuAdapter(menuItems, viewType)
    }
}