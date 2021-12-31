package com.near.labs.fragments.nft

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.near.labs.activities.NFTCreatorActivity
import com.near.labs.activities.SettingsActivity
import com.near.labs.data.NFT
import com.near.labs.databinding.FragmentNftAllBinding
import com.near.labs.models.NFTHomeViewModel


class NFTAll : NFTBase() {
    private lateinit var binding: FragmentNftAllBinding

    private val model: NFTHomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNftAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNFTsRecycler(binding.nftArtCategoryRecycler, isVertical = true)
        binding.nftAllTitle.action.setOnClickListener {
            val intent = Intent(requireContext(), NFTCreatorActivity::class.java)
            startActivity(intent)
        }

        model.nfts.observe(viewLifecycleOwner, { data ->
            if (data == null) return@observe
            this.nfts.clear()
            this.nfts.addAll(data)
            nfTsAdapter.notifyDataSetChanged()
        })


        val fakeData = mutableListOf<NFT>()
        fakeData.add(
            NFT(
                category = "Digital Art",
                title = "Vecotry Illustration ",
                image = "art1",
                id = "8950"
            )
        )
        fakeData.add(
            NFT(
                category = "Digital Art",
                title = "Edge Illustration ",
                image = "art2",
                id = "8544"
            )
        )
        fakeData.add(
            NFT(
                category = "Digital Art",
                title = "Vecotry Illustration ",
                image = "art1",
                id = "8950"
            )
        )
        fakeData.add(
            NFT(
                category = "Digital Art",
                title = "Edge Illustration ",
                image = "art2",
                id = "8544"
            )
        )
        model.nfts.value = fakeData


    }
}