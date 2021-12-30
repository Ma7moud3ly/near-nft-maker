package com.near.labs.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.databinding.FragmentSignupHomeBinding
import com.near.labs.utils.TextValidator
import com.near.labs.data.VER_TYPE


class Home : Fragment() {
    private lateinit var binding: FragmentSignupHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initInputValidation()


        binding.homeGetStarted.setOnClickListener {

            val action =
                if (binding.startWith == VER_TYPE.EMAIL) HomeDirections.actionHome2ToEmailVerification(
                    email = binding.homeEmailInput.text.toString()
                ) else HomeDirections.actionHome2ToPhoneVerification(
                    binding.homePhoneInput.text.toString()
                )

            findNavController().navigate(action)

        }

    }


    private fun initInputValidation() {

        binding.startWith = VER_TYPE.EMAIL
        binding.homeEmailTab.setOnClickListener { switchVerificationMethod(VER_TYPE.EMAIL) }
        binding.homePhoneTab.setOnClickListener { switchVerificationMethod(VER_TYPE.PHONE) }

        binding.homeEmailInput.addTextChangedListener(object :
            TextValidator(binding.homeEmailInput, VER_TYPE.EMAIL) {
            override fun validate(valid: Boolean) {
                binding.homeGetStarted.isEnabled = (valid && binding.startWith == VER_TYPE.EMAIL)
            }
        })
        binding.homePhoneInput.addTextChangedListener(object :
            TextValidator(binding.homePhoneInput, VER_TYPE.PHONE) {
            override fun validate(valid: Boolean) {
                binding.homeGetStarted.isEnabled = (valid && binding.startWith == VER_TYPE.PHONE)
            }
        })
    }

    private fun switchVerificationMethod(type: VER_TYPE) {
        binding.startWith = type
        binding.homeEmailInput.setText("")
        binding.homePhoneInput.setText("")
        binding.homeGetStarted.isEnabled = false

    }


}