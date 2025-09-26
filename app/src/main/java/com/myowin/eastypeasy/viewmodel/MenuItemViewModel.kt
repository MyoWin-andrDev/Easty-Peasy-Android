package com.myowin.eastypeasy.viewmodel

import androidx.lifecycle.ViewModel
import com.myowin.eastypeasy.model.dto.AddonItem
import com.myowin.eastypeasy.model.dto.MandatoryItem
import com.myowin.eastypeasy.model.dto.MenuItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MenuItemViewModel @Inject constructor() : ViewModel() {
    private val _menuItem = MutableStateFlow<MenuItem?>(null)
    val menuItem: StateFlow<MenuItem?> = _menuItem.asStateFlow()

    private val _quantity = MutableStateFlow(1)
    val quantity: StateFlow<Int> = _quantity.asStateFlow()

    private val _selectedMandatory = mutableMapOf<Int, MandatoryItem>()
    private val _selectedAddOns = mutableSetOf<AddonItem>()

    fun setMenuItem(item: MenuItem) {
        _menuItem.value = item
    }

    fun increaseQuantity() {
        _quantity.value += 1
    }

    fun decreaseQuantity() {
        if (_quantity.value > 1) {
            _quantity.value -= 1
        }
    }

    fun selectMandatoryItem(optionId: Int, item: MandatoryItem) {
        _selectedMandatory[optionId] = item
    }

    fun toggleAddOnItem(item: AddonItem, isChecked: Boolean) {
        if (isChecked) {
            _selectedAddOns.add(item)
        } else {
            _selectedAddOns.remove(item)
        }
    }

    fun getTotalPrice(): Float {
        val basePrice = _menuItem.value?.amount ?: 0f
        val mandatoryTotal = _selectedMandatory.values.sumOf { it.amount.toDouble() }.toFloat()
        val addOnTotal = _selectedAddOns.sumOf { it.amount.toDouble() }.toFloat()
        return (basePrice + mandatoryTotal + addOnTotal) * _quantity.value
    }
}