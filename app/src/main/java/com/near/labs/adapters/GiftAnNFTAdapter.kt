package com.near.labs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.near.labs.data.User
import com.near.labs.databinding.ItemGiftPersonBinding


class GiftAnNFTAdapter(
    private val list: MutableList<User>,
) :
    RecyclerView.Adapter<GiftAnNFTAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemGiftPersonBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemGiftPersonBinding =
            ItemGiftPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        position?.let { position ->
            val user: User = list[position]
            holder.binding.user = user
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}