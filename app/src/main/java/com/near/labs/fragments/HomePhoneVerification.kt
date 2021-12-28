package com.near.labs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.databinding.FragmentHomeBinding
import com.near.labs.databinding.FragmentVerificationEmailBinding
import com.near.labs.databinding.FragmentVerificationPhoneBinding
import com.near.labs.databinding.FragmentVerificationPhoneBindingImpl
import android.widget.Toast

import com.near.labs.MainActivity

import org.jetbrains.annotations.NotNull

import com.poovam.pinedittextfield.PinField

import android.R

import com.poovam.pinedittextfield.LinePinField


class HomePhoneVerification : Fragment() {
    private lateinit var binding: FragmentVerificationPhoneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerificationPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("phone").let {
            binding.phone.text = it
        }


        binding.verificationPin.onTextCompleteListener = object : PinField.OnTextCompleteListener {
            override fun onTextComplete(enteredText: String): Boolean {
                binding.next = true
                return true // Return false to keep the keyboard open else return true to close the keyboard
            }
        }

    }

}