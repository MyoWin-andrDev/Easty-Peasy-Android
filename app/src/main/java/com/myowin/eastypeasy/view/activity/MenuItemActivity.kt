package com.myowin.eastypeasy.view.activity

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.ActivityMenuItemBinding
import com.myowin.eastypeasy.model.dto.AddonItem
import com.myowin.eastypeasy.model.dto.MandatoryItem
import com.myowin.eastypeasy.model.dto.MenuItem
import com.myowin.eastypeasy.viewmodel.MenuItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        setupObservers()
        initializeData()
    }

    private fun setupClickListeners() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.ivCart.setOnClickListener {
            // Handle cart click
        }

        binding.ibMinus.setOnClickListener {
            viewModel.decreaseQuantity()
        }

        binding.ibAdd.setOnClickListener {
            viewModel.increaseQuantity()
        }

        binding.btAddToCart.setOnClickListener {
            menuItem?.let { item ->
                val cartItem = viewModel.prepareCartItem(item)
                // Add to cart logic here
                Timber.d("Adding to cart: ${cartItem.name}")
            }
        }
    }

    private fun setupObservers() {
        observeMenuItem()
        observeTotalPrice()
        observeQuantity()
    }

    private fun observeMenuItem() {
        lifecycleScope.launch {
            viewModel.menuItem.collectLatest { item ->
                item?.let {
                    updateUI(it)
                    setupMandatoryOptions(it.mandatoryOption)
                    setupAddOnOptions(it.addOnOption)
                }
            }
        }
    }

    private fun observeTotalPrice() {
        lifecycleScope.launch {
            viewModel.totalPrice.collectLatest { totalPrice ->
                binding.tvMenuPrice.text = "$${String.format("%.2f", totalPrice)}"
            }
        }
    }

    private fun observeQuantity() {
        lifecycleScope.launch {
            viewModel.quantity.collectLatest { quantity ->
                binding.tvCount.text = quantity.toString()
            }
        }
    }

    private fun initializeData() {
        menuItem?.let {
            viewModel.setMenuItem(it)
        }
    }

    private fun updateUI(menuItem: MenuItem) {
        binding.tvMenuName.text = menuItem.name
        binding.tvMenuPrice.text = "$${String.format("%.2f", menuItem.amount)}"
        binding.tvDescription.text = menuItem.description

        // Load image if you have an ImageView for the hero image
        // Glide.with(this).load(menuItem.imageUrl).into(binding.ivHeroImage)
    }

    private fun setupMandatoryOptions(mandatoryOptions: List<MandatoryOption>) {
        val radioGroupContainer = binding.layoutMandatory.findViewById<RadioGroup>(R.id.rgMandatoryPick)
        radioGroupContainer.removeAllViews()

        mandatoryOptions.forEach { option ->
            // Create section title
            val titleView = LayoutInflater.from(this).inflate(R.layout.layout_section_title, null)
            titleView.findViewById<TextView>(R.id.tvSectionTitle).text = option.title

            val pickCountView = titleView.findViewById<TextView>(R.id.tvPickCount)
            pickCountView.text = "Pick 1"

            radioGroupContainer.addView(titleView)

            // Create radio buttons for each item
            option.itemList.forEach { item ->
                val radioButtonView = LayoutInflater.from(this).inflate(R.layout.layout_mandatory_item, null)
                val radioButton = radioButtonView.findViewById<RadioButton>(R.id.rb)
                val priceTextView = radioButtonView.findViewById<TextView>(R.id.tvPrice)

                radioButton.text = item.title
                priceTextView.text = if (item.amount > 0) "+ $${String.format("%.2f", item.amount)}" else ""
                radioButton.tag = Pair(option.id, item.id)

                radioButton.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        viewModel.selectMandatoryItem(option.id, item.id)
                    }
                }

                radioGroupContainer.addView(radioButtonView)
            }

            // Add divider
            if (mandatoryOptions.last() != option) {
                val divider = LayoutInflater.from(this).inflate(R.layout.layout_divider, null)
                radioGroupContainer.addView(divider)
            }
        }
    }

    private fun setupAddOnOptions(addOnOptions: List<AddOnOption>) {
        val addOnContainer = binding.layoutOptional.findViewById<LinearLayout>(R.id.llAddOnContainer)
        addOnContainer.removeAllViews()

        addOnOptions.forEach { option ->
            // Create section title
            val titleView = LayoutInflater.from(this).inflate(R.layout.layout_section_title, null)
            titleView.findViewById<TextView>(R.id.tvSectionTitle).text = option.title

            val pickCountView = titleView.findViewById<TextView>(R.id.tvPickCount)
            pickCountView.text = "Optional"

            addOnContainer.addView(titleView)

            // Create checkboxes for each item
            option.itemList.forEach { item ->
                val checkboxView = LayoutInflater.from(this).inflate(R.layout.layout_optional_item, null)
                val checkbox = checkboxView.findViewById<CheckBox>(R.id.cb)
                val textView = checkboxView.findViewById<TextView>(R.id.tvCheckBox)
                val priceView = checkboxView.findViewById<TextView>(R.id.tvPrice)

                textView.text = item.title
                priceView.text = "+ $${String.format("%.2f", item.amount)}"

                checkbox.setOnCheckedChangeListener { _, isChecked ->
                    viewModel.toggleAddOnItem(item.id, isChecked)
                }

                addOnContainer.addView(checkboxView)
            }

            // Add divider
            if (addOnOptions.last() != option) {
                val divider = LayoutInflater.from(this).inflate(R.layout.layout_divider, null)
                addOnContainer.addView(divider)
            }
        }
    }
}