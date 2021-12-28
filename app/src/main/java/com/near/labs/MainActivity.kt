package com.near.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import android.os.Build
import android.view.Window
import androidx.core.content.ContextCompat
import com.near.labs.databinding.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        //var binding = FragmentVerificationEmailBinding.inflate(layoutInflater)
        //var binding = FragmentCreateNearAccountBinding.inflate(layoutInflater)
        var binding = FragmentNftBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}