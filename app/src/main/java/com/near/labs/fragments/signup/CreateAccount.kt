package com.near.labs.fragments.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.near.labs.activities.MainActivity
import com.near.labs.activities.NFTActivity
import com.near.labs.databinding.FragmentSignupCreateBinding


class CreateAccount : Fragment() {
    private lateinit var binding: FragmentSignupCreateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(activity as MainActivity, NFTActivity::class.java)

        binding.next.setOnClickListener {
            startActivity(intent)
            activity?.finish()
        }

        binding.createHeader.headerExit.setOnClickListener { findNavController().popBackStack() }


    }

}