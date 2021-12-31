package com.near.labs.fragments.nft.creator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.near.labs.App
import com.near.labs.data.NFT
import com.near.labs.data.User
import com.near.labs.databinding.FragmentNftPreviewBinding
import com.near.labs.fragments.nft.NFTBase
import com.near.labs.repositories.localImage
import com.near.labs.utils.RecyclerItemResizer
import java.io.File


class NFTPreview : NFTBase() {
    private lateinit var binding: FragmentNftPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNftPreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.nftPreviewHeader.headerExit.setOnClickListener { findNavController().popBackStack() }
        binding.nftPreviewMint.setOnClickListener { activity?.finish() }

        val user = User("John Doe", "john_doe", "")

        arguments?.getSerializable("nft").let {
            val nft = it as NFT
            initNFTPreview(nft, user)
        }


    }

    private fun initNFTPreview(nft: NFT, user: User) {
        binding.nftPreviewItem.nft = nft
        binding.nftPreviewItem.user = user
        binding.nftPreviewItem.preview = true
        localImage(binding.nftPreviewItem.nftImage, nft.imageUri)
        RecyclerItemResizer.fitScreen(binding.nftPreviewItem.cardLayout)
    }

}