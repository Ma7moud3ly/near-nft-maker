package com.near.labs.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.databinding.FragmentVerificationPhoneBinding

import com.poovam.pinedittextfield.PinField


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

        binding.toNext.setOnClickListener {
            val action =
                HomePhoneVerificationDirections.actionHomePhoneVerificationToHomeCreateAccount()
            findNavController().navigate(action)
        }

    }

}