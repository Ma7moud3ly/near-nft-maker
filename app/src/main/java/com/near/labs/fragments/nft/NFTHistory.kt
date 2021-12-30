package com.near.labs.fragments.nft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.near.labs.data.TRANS_TYPE
import com.near.labs.data.Transaction
import com.near.labs.databinding.FragmentNftHistoryBinding
import com.near.labs.models.NFTHomeViewModel


class NFTHistory : NFTBase() {
    private lateinit var binding: FragmentNftHistoryBinding
    private val model: NFTHomeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNftHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTransactionsRecycler(binding.nftHistoryRecycler)
        model.transactions.observe(viewLifecycleOwner, { data ->
            if (data == null) return@observe
            this.transactions.clear()
            this.transactions.addAll(data)
            transactionsAdapter.notifyDataSetChanged()
        })

        val fakeData2 = mutableListOf<Transaction>()
        fakeData2.add(Transaction("12566", "michael.near", date = "1", TRANS_TYPE.SEND))
        fakeData2.add(Transaction("4452", "john.near", date = "3", TRANS_TYPE.RECEIVE))
        fakeData2.add(Transaction("1856", "tomas.adams", date = "5", TRANS_TYPE.SEND))
        fakeData2.add(Transaction("875862", "will.smith", date = "10", TRANS_TYPE.RECEIVE))

        model.transactions.value = fakeData2

        binding.nftHistoryAll.setOnClickListener { filterTransactions(TRANS_TYPE.ALL) }
        binding.nftHistorySent.setOnClickListener { filterTransactions(TRANS_TYPE.SEND) }
        binding.nftHistoryReceived.setOnClickListener { filterTransactions(TRANS_TYPE.RECEIVE) }

    }

    private fun filterTransactions(type: TRANS_TYPE) {
        val temp = mutableListOf<Transaction>()
        model.transactions.value?.forEach { trans ->
            if (trans.type == type || type == TRANS_TYPE.ALL) temp.add(trans)
        }
        transactions.clear()
        transactions.addAll(temp)
        transactionsAdapter.notifyDataSetChanged()
    }

}