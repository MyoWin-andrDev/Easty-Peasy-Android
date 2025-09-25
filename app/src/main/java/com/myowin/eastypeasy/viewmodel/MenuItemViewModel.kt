package com.myowin.eastypeasy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myowin.eastypeasy.model.dto.AddonItem
import com.myowin.eastypeasy.model.dto.MandatoryItem
import com.myowin.eastypeasy.model.dto.MenuItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MenuItemViewModel @Inject constructor() : ViewModel() {

    private val _menuItem = MutableStateFlow<MenuItem?>(null)
    val menuItem: StateFlow<MenuItem?> = _menuItem.asStateFlow()

    private val _quantity = MutableStateFlow(1)
    val quantity: StateFlow<Int> = _quantity.asStateFlow()

    private val _selectedMandatoryItems = MutableStateFlow<Map<Int, Int>>(emptyMap())
    private val _selectedAddOnItems = MutableStateFlow<Set<Int>>(emptySet())

    val totalPrice: StateFlow<Float> = combine(
        _menuItem,
        _quantity,
        _selectedMandatoryItems,
        _selectedAddOnItems
    ) { item, qty, mandatory, addOns ->
        calculateTotalPrice(item, qty, mandatory, addOns)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), 0f)

    fun setMenuItem(item: MenuItem) {
        _menuItem.value = item
        // Auto-select first option in each mandatory group
        item.mandatoryOption.forEach { option ->
            option.itemList.firstOrNull()?.let { firstItem ->
                selectMandatoryItem(option.id, firstItem.id)
            }
        }
    }

    fun increaseQuantity() {
        _quantity.value += 1
    }

    fun decreaseQuantity() {
        if (_quantity.value > 1) {
            _quantity.value -= 1
        }
    }

    fun selectMandatoryItem(optionId: Int, itemId: Int) {
        val currentSelection = _selectedMandatoryItems.value.toMutableMap()
        currentSelection[optionId] = itemId
        _selectedMandatoryItems.value = currentSelection
    }

    fun toggleAddOnItem(itemId: Int, isChecked: Boolean) {
        val currentSelection = _selectedAddOnItems.value.toMutableSet()
        if (isChecked) {
            currentSelection.add(itemId)
        } else {
            currentSelection.remove(itemId)
        }
        _selectedAddOnItems.value = currentSelection
    }

    private fun calculateTotalPrice(
        item: MenuItem?,
        quantity: Int,
        mandatory: Map<Int, Int>,
        addOns: Set<Int>
    ): Float {
        if (item == null) return 0f

        var basePrice = item.amount

        // Add mandatory items price
        mandatory.values.forEach { itemId ->
            item.mandatoryOption.flatMap { it.itemList }
                .find { it.id == itemId }
                ?.amount?.let { basePrice += it }
        }

        // Add add-on items price
        addOns.forEach { itemId ->
            item.addOnOption.flatMap { it.itemList }
                .find { it.id == itemId }
                ?.amount?.let { basePrice += it }
        }

        return basePrice * quantity
    }

    fun prepareCartItem(menuItem: MenuItem): CartItem {
        val selectedMandatory = _selectedMandatoryItems.value.mapValues { (optionId, itemId) ->
            menuItem.mandatoryOption.flatMap { it.itemList }.find { it.id == itemId }!!
        }

        val selectedAddOns = _selectedAddOnItems.value.map { itemId ->
            menuItem.addOnOption.flatMap { it.itemList }.find { it.id == itemId }!!
        }

        return CartItem(
            menuItem = menuItem,
            quantity = _quantity.value,
            selectedMandatory = selectedMandatory,
            selectedAddOns = selectedAddOns,
            note = "" // You can add note functionality later
        )
    }
}

// Add this data class for cart items
data class CartItem(
    val menuItem: MenuItem,
    val quantity: Int,
    val selectedMandatory: Map<Int, MandatoryItem>,
    val selectedAddOns: List<AddonItem>,
    val note: String
)