package com.near.labs.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.R
import com.near.labs.databinding.FragmentSignupVerificationBinding

import com.poovam.pinedittextfield.PinField


class PhoneVerification : Fragment() {
    private lateinit var binding: FragmentSignupVerificationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verificationMessage.text = getString(R.string.verification_to_phone)
        binding.verificationAlternative.text =
            getString(R.string.verification_send_to_different_phone)


        arguments?.getString("phone").let {
            binding.verificationId.text = it
        }


        binding.verificationPin.onTextCompleteListener = object : PinField.OnTextCompleteListener {
            override fun onTextComplete(enteredText: String): Boolean {
                binding.next = true
                return true // Return false to keep the keyboard open else return true to close the keyboard
            }
        }

        binding.toNext.setOnClickListener {
            val action =
                PhoneVerificationDirections.actionPhoneVerificationToCreateAccount()
            findNavController().navigate(action)
        }

        binding.verificationHeader.headerExit.setOnClickListener { findNavController().popBackStack() }

    }

}