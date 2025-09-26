package com.myowin.eastypeasy.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.activity.viewBinding
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.radiobutton.MaterialRadioButton
import com.google.android.material.snackbar.Snackbar
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.ActivityMenuItemBinding
import com.myowin.eastypeasy.model.dto.AddOnOption
import com.myowin.eastypeasy.model.dto.AddonItem
import com.myowin.eastypeasy.model.dto.MandatoryItem
import com.myowin.eastypeasy.model.dto.MandatoryOption
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.viewmodel.MenuItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MenuItemActivity : AppCompatActivity() {
    private val binding: ActivityMenuItemBinding by viewBinding()
    private val viewModel: MenuItemViewModel by viewModels()

    companion object {
        const val EXTRA_MENU_ITEM = "extra_menu_item"
    }

    private val menuItem by lazy {
        intent.getParcelableExtra<MenuItem>(EXTRA_MENU_ITEM)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupClickListeners()
        initializeData()
    }

    private fun setupClickListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.ibMinus.setOnClickListener {
            viewModel.decreaseQuantity()
            updateQuantity()
        }

        binding.ibAdd.setOnClickListener {
            viewModel.increaseQuantity()
            updateQuantity()
        }

        binding.btAddToCart.setOnClickListener {
            // Handle add to cart
            showAddToCartSuccess()
        }
    }

    private fun initializeData() {
        menuItem?.let { item ->
            viewModel.setMenuItem(item)
            updateUI(item)
            setupMandatoryOptions(item.mandatoryOption)
            setupAddOnOptions(item.addOnOption)
        }
    }

    private fun updateUI(menuItem: MenuItem) {
        binding.tvMenuName.text = menuItem.name
        binding.tvMenuPrice.text = "$${menuItem.amount}"
        binding.tvDescription.text = menuItem.description
        // Load image if needed
    }

    private fun updateQuantity() {
        binding.tvCount.text = viewModel.quantity.value.toString()
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        binding.btAddToCart.text = "Add To Cart  -  $${String.format("%.2f", viewModel.getTotalPrice())}"
    }

    private fun showAddToCartSuccess() {
        val menuItemName = viewModel.menuItem.value?.name ?: "Item"
        val message = "$menuItemName added to cart"

        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
            .setAction("View Cart") {
                // Navigate to cart or show cart dialog
                //showCart()
            }
            .setActionTextColor(ContextCompat.getColor(this, R.color.colorSuccess))
            .show()
    }

    private fun setupMandatoryOptions(mandatoryOptions: List<MandatoryOption>) {
        val radioGroup = binding.layoutMandatory.rgMandatoryPick
        radioGroup.removeAllViews()

        // For now, we assume a single mandatory group (can extend later for multiple)
        mandatoryOptions.firstOrNull()?.let { option ->
            binding.layoutMandatory.tvMandatoryPick.text = option.title

            // Create radio buttons for each item
            option.itemList.forEach { item ->
                val radioButton = createRadioButton(item, radioGroup)
                radioGroup.addView(radioButton)
            }

            // Handle selection at group level
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedButton = group.findViewById<MaterialRadioButton>(checkedId)
                val selectedItem = selectedButton?.tag as? MandatoryItem
                selectedItem?.let {
                    viewModel.selectMandatoryItem(option.id, it)
                    updateTotalPrice()
                }
                binding.layoutMandatory.tvPick.visibility = View.INVISIBLE
                binding.layoutMandatory.tvCompleted.visibility = View.VISIBLE
                binding.btAddToCart.isEnabled = true
            }
        }
    }

    /**
     * Helper to create a radio button with proper styling and tagging.
     */
    private fun createRadioButton(item: MandatoryItem, parent: ViewGroup): MaterialRadioButton {
        return (LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_mandatory_item, parent, false) as MaterialRadioButton).apply {
            id = View.generateViewId()
            text = "${item.title} ${if (item.amount > 0) "+ $${item.amount}" else ""}"
            tag = item
        }
    }



    private fun setupAddOnOptions(addOnOptions: List<AddOnOption>) {
        val optionalContainer = binding.llOptional

        addOnOptions.forEach { option ->
            optionalContainer.addView(createAddOnSection(option))
        }
    }

    private fun createAddOnSection(option: AddOnOption): View {
        return LayoutInflater.from(this).inflate(R.layout.layout_optional, null).apply {
            findViewById<TextView>(R.id.tvOptionalPick).text = option.title

            val checkboxesContainer = findViewById<LinearLayout>(R.id.layoutOptionalSample)

            option.itemList.forEach { item ->
                checkboxesContainer.addView(createCheckboxItem(item))
            }
        }
    }

    private fun createCheckboxItem(item: AddonItem): View {
        return LayoutInflater.from(this).inflate(R.layout.layout_optional_item, null).apply {
            findViewById<TextView>(R.id.tvCheckBox).text = item.title
            findViewById<TextView>(R.id.tvPrice).text = "+ $${item.amount}"

            val checkbox = findViewById<MaterialCheckBox>(R.id.cb)

            // Make entire row clickable
            setOnClickListener {
                checkbox.isChecked = !checkbox.isChecked
            }

            checkbox.setOnCheckedChangeListener { _, isChecked ->
                viewModel.toggleAddOnItem(item, isChecked)
                updateTotalPrice()
            }
        }
    }


}