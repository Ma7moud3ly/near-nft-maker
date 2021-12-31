package com.near.labs.activities

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.near.labs.R
import com.near.labs.databinding.ActivitySettingsBinding
import com.near.labs.databinding.ItemChangeDialogBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window


class SettingsActivity : BaseActivity() {
    lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAppBar()

        binding.settingsName.action.setOnClickListener { changeDialog(title = "Name") }
        binding.settingsEmail.action.setOnClickListener { changeDialog(title = "Email") }
        binding.settingsPhone.action.setOnClickListener { changeDialog(title = "Phone") }


    }

    private fun initAppBar() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        setSupportActionBar(binding.toolbarLayout.settingToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.up_icon);
    }

    private fun changeDialog(title: String) {

        val dialog = Dialog(this)
        val dialogBinding: ItemChangeDialogBinding =
            ItemChangeDialogBinding.inflate(LayoutInflater.from(this))
        dialogBinding.title = title
        dialogBinding.changeDialogClose.setOnClickListener { dialog.dismiss() }
        dialogBinding.changeDialogConfirm.setOnClickListener {
            val text = dialogBinding.changeDialogInput.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.setContentView(dialogBinding.root)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        dialog.window?.setLayout(
            displayMetrics.widthPixels,
           ViewGroup.LayoutParams.WRAP_CONTENT
        ); //Controlling width and height.
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

}