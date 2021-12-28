package com.near.labs.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.databinding.FragmentVerificationEmailBinding
import com.poovam.pinedittextfield.PinField


class HomeEmailVerification : Fragment() {
    private lateinit var binding: FragmentVerificationEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerificationEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("email").let {
            binding.email.text = it
        }

        binding.verificationPin.onTextCompleteListener = object : PinField.OnTextCompleteListener {
            override fun onTextComplete(enteredText: String): Boolean {
                binding.next = true
                return true // Return false to keep the keyboard open else return true to close the keyboard
            }
        }

        binding.toNext.setOnClickListener {
            val action =
                HomeEmailVerificationDirections.actionHomeEmailVerificationToHomeCreateAccount()
            findNavController().navigate(action)
        }


    }

}