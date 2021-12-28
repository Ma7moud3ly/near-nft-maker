package com.near.labs.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.near.labs.MainActivity
import com.near.labs.NFTActivity
import com.near.labs.databinding.FragmentCreateAccountBinding


class HomeCreateAccount : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(activity as MainActivity, NFTActivity::class.java)

        binding.next.setOnClickListener {
            startActivity(intent)
            activity?.finish()
        }

    }

}