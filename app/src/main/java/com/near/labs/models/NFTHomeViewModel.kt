package com.near.labs.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.near.labs.data.NFT
import com.near.labs.data.Transaction

class NFTHomeViewModel : ViewModel() {
    val nfts: MutableLiveData<List<NFT>> by lazy {
        MutableLiveData<List<NFT>>()
    }

    val transactions: MutableLiveData<List<Transaction>> by lazy {
        MutableLiveData<List<Transaction>>()
    }



}