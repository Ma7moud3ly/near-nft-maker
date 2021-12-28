package com.near.labs.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.databinding.FragmentHomeBinding
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.near.labs.util.TextValidator


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var input: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initInputValidation()

        binding.startWithEmail = true
        binding.homeEmailTab.setOnClickListener {
            binding.startWithEmail = true
            binding.homeGetStarted.isEnabled = false
        }
        binding.homePhoneTab.setOnClickListener {
            binding.startWithEmail = false
            binding.homeGetStarted.isEnabled = false
        }
        binding.homeGetStarted.setOnClickListener {

            if (binding.startWithEmail == true) {
                val action = HomeFragmentDirections.actionHomeFragmentToHomeEmailVerification()
                findNavController().navigate(action)
            } else {
                val action = HomeFragmentDirections.actionHomeFragmentToHomePhoneVerification()
                findNavController().navigate(action)
            }
        }

    }

    private fun initInputValidation() {
        binding.homeEmailInput.addTextChangedListener(object :
            TextValidator(binding.homeEmailInput, 1) {
            override fun validate(valid: Boolean) {
                binding.homeGetStarted.isEnabled = (valid && binding.startWithEmail == true)
            }
        })
        binding.homePhoneInput.addTextChangedListener(object :
            TextValidator(binding.homePhoneTab, 2) {
            override fun validate(valid: Boolean) {
                binding.homeGetStarted.isEnabled = (valid && binding.startWithEmail == false)
            }
        })
    }

}