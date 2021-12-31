package com.near.labs.data

import android.net.Uri
import java.io.Serializable

class NFT(
    val id: String,
    val category: String,
    val title: String,
    var image: String? = "",
    val imageUri: Uri? = null,
    var description: String = "",
    var properties: List<NFTProperty> = mutableListOf(),
) : Serializable