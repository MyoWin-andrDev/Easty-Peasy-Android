package com.myowin.eastypeasy.view.activity

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.myowin.eastypeasy.R
import com.myowin.eastypeasy.databinding.ActivityMenuItemBinding
import com.myowin.eastypeasy.model.dto.AddonItem
import com.myowin.eastypeasy.model.dto.MandatoryItem
import com.myowin.eastypeasy.viewmodel.MenuItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuItemActivity : AppCompatActivity() {
    private val binding : ActivityMenuItemBinding by viewBinding()
    private val viewModel : MenuItemViewModel by viewModels()

    private lateinit var radioGroup : RadioGroup
    private lateinit var addOnLayout : ConstraintLayout
    private lateinit var mandatoryList : List<MandatoryItem>
    private lateinit var addOnList : List<AddonItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}