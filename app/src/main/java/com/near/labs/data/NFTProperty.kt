package com.near.labs.data

class NFTProperty(val key: String, val value: String){
    override fun toString(): String {
        return "$key: $value"
    }
}