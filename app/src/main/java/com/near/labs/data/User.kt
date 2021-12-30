package com.near.labs.data

class User(val name: String, val id: String, val image: String) {
    fun nameAbbrev(): String {
        var abbrev = ""
        this.name.split(" ").forEach {
            if (it.length > 1) abbrev += it.substring(0, 1)
        }
        if (abbrev == "") abbrev = name
        return abbrev
    }
}
