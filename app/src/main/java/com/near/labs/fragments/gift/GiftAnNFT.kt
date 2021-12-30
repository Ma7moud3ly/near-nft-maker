package com.near.labs.fragments.gift

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.near.labs.App
import com.near.labs.activities.MainActivity
import com.near.labs.activities.NFTActivity
import com.near.labs.adapters.GiftAnNFTAdapter
import com.near.labs.data.User
import com.near.labs.databinding.FragmentGiftBinding
import com.near.labs.models.GiftViewModel


class GiftAnNFT : Fragment() {
    private lateinit var binding: FragmentGiftBinding
    private lateinit var recyclerAdapter: GiftAnNFTAdapter
    private val model: GiftViewModel by activityViewModels()
    private val users = mutableListOf<User>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGiftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler(binding.giftRecycler)

        model.users.observe(viewLifecycleOwner, { users ->
            if (users == null) return@observe
            this.users.clear()
            this.users.addAll(users)
            recyclerAdapter.notifyDataSetChanged()
        })


        val fakeUsers = mutableListOf<User>()
        fakeUsers.add(User("Darlene Robertson", "darlene", ""))
        fakeUsers.add(User("Jacob Jones", "jones", ""))
        fakeUsers.add(User("Jenny Wilson", "wilson", ""))
        fakeUsers.add(User("Ronald Richards", "richards", ""))
        fakeUsers.add(User("Ronald Richards", "richards", ""))
        fakeUsers.add(User("Cameron Williamson", "williamson", ""))
        fakeUsers.add(User("Darrell Steward", "steward", ""))
        fakeUsers.add(User("Wade Warren", "warren", ""))
        fakeUsers.add(User("Courtney Henry", "henry", ""))

        model.users.value = fakeUsers


        binding.giftSend.setOnClickListener {
            val intent = Intent(activity as MainActivity, NFTActivity::class.java)
            startActivity(intent)
        }

        binding.giftHeader.headerExit.setOnClickListener { findNavController().popBackStack() }


    }

    private fun initRecycler(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager =
            GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.HORIZONTAL
            )
        )


        recyclerAdapter = GiftAnNFTAdapter(users)

        recyclerView.adapter = recyclerAdapter

    }

}