package com.near.labs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.near.labs.data.Transaction
import com.near.labs.databinding.ItemNftTransactionBinding


class TransactionsAdapter(
    private val list: MutableList<Transaction>,
) :
    RecyclerView.Adapter<TransactionsAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemNftTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemNftTransactionBinding =
            ItemNftTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        position?.let { position ->
            val item: Transaction = list[position]
            holder.binding.transaction = item
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}