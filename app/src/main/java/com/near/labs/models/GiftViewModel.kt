package com.near.labs.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.near.labs.data.User

class GiftViewModel : ViewModel() {
    val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>()
    }


}