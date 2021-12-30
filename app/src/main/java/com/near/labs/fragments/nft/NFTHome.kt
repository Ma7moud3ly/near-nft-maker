package com.near.labs.fragments.nft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.near.labs.data.NFT
import com.near.labs.data.TRANS_TYPE
import com.near.labs.data.Transaction
import com.near.labs.databinding.FragmentNftHomeBinding
import com.near.labs.models.NFTHomeViewModel


class NFTHome : NFTBase() {
    private lateinit var binding: FragmentNftHomeBinding

    private val model: NFTHomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNftHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNFTsRecycler(binding.nftArtCategoryRecycler,isVertical = false)
        initTransactionsRecycler(binding.nftTransactionsRecycler)

        binding.nftArtsTitle.action.setOnClickListener {
            val action = NFTHomeDirections.actionNFTHomeToNFTAll()
            findNavController().navigate(action)
        }
        binding.nftTransactionsTitle.action.setOnClickListener {
            val action = NFTHomeDirections.actionNFTHomeToNFTHistory()
            findNavController().navigate(action)
        }

        model.nfts.observe(viewLifecycleOwner, { data ->
            if (data == null) return@observe
            this.nfts.clear()
            this.nfts.addAll(data)
            nfTsAdapter.notifyDataSetChanged()
        })

        model.transactions.observe(viewLifecycleOwner, { data ->
            if (data == null) return@observe
            this.transactions.clear()
            this.transactions.addAll(data)
            transactionsAdapter.notifyDataSetChanged()
        })


        val fakeData = mutableListOf<NFT>()
        fakeData.add(NFT("Digital Art", "Vecotry Illustration ", "art1", "8950"))
        fakeData.add(NFT("Digital Art", "Vecotry Illustration ", "art2", "4525"))
        fakeData.add(NFT("Digital Art", "Vecotry Illustration ", "art1", "3250"))
        fakeData.add(NFT("Digital Art", "Vecotry Illustration ", "art2", "7852"))
        model.nfts.value = fakeData

        val fakeData2 = mutableListOf<Transaction>()
        fakeData2.add(Transaction("12566", "michael.near", date = "1", TRANS_TYPE.SEND))
        fakeData2.add(Transaction("4452", "john.near", date = "3", TRANS_TYPE.RECEIVE))
        fakeData2.add(Transaction("1856", "tomas.adams", date = "5", TRANS_TYPE.SEND))
        fakeData2.add(Transaction("875862", "will.smith", date = "10", TRANS_TYPE.RECEIVE))

        model.transactions.value = fakeData2


    }




}