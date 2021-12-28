package com.near.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import android.os.Build
import android.view.Window
import androidx.core.content.ContextCompat
import com.near.labs.databinding.*


class NFTActivity : AppCompatActivity() {
    lateinit var binding:FragmentNftBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = FragmentNftBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}