package com.near.labs.adapters

import android.app.Activity
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.near.labs.data.NFT
import com.near.labs.databinding.ItemNftBinding


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
        if (isVertical) {
            val context = binding.root.context
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            binding.cardLayout.layoutParams.width = displayMetrics.widthPixels
            binding.cardLayout.layoutParams.height = (displayMetrics.widthPixels * 0.5).toInt()
        }
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