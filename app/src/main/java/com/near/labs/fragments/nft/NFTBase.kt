package com.near.labs.fragments.nft

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.near.labs.adapters.NFTsAdapter
import com.near.labs.adapters.TransactionsAdapter
import com.near.labs.data.NFT
import com.near.labs.data.Transaction

open class NFTBase : Fragment() {
    lateinit var transactionsAdapter: TransactionsAdapter
    val transactions = mutableListOf<Transaction>()
     lateinit var nfTsAdapter: NFTsAdapter
    val nfts = mutableListOf<NFT>()


    fun initTransactionsRecycler(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager =
            GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayoutManager
        transactionsAdapter = TransactionsAdapter(transactions)
        recyclerView.adapter = transactionsAdapter
    }

    fun initNFTsRecycler(recyclerView: RecyclerView, isVertical: Boolean) {
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager =
            GridLayoutManager(
                requireContext(),
                1,
                if (isVertical) GridLayoutManager.VERTICAL else GridLayoutManager.HORIZONTAL,
                false
            )
        recyclerView.layoutManager = gridLayoutManager
        nfTsAdapter = NFTsAdapter(nfts,isVertical)
        recyclerView.adapter = nfTsAdapter
    }


}