package com.near.labs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.near.labs.data.NFT
import com.near.labs.databinding.ItemNftBinding
import com.near.labs.utils.RecyclerItemResizer


class NFTsAdapter(
    private val list: MutableList<NFT>,
    private val isVertical: Boolean
) :
    RecyclerView.Adapter<NFTsAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemNftBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemNftBinding =
            ItemNftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        if (isVertical) RecyclerItemResizer.fitScreen(binding.cardLayout)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        position?.let { position ->
            val nft: NFT = list[position]
            holder.binding.nft = nft
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}