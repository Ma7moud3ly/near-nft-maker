package com.near.labs.util

import android.text.Editable
import android.text.TextUtils

import android.widget.TextView

import android.text.TextWatcher


abstract class TextValidator(private val textView: TextView, private val type: Int) : TextWatcher {
    abstract fun validate(valid: Boolean)
    override fun afterTextChanged(s: Editable) {
        val text = textView.text.toString()
        if (type == 1) validate(isEmail(text))
        else if (type == 2) validate(isPhone(text))
    }

    override fun beforeTextChanged(
        s: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ) { /* Don't care */
    }

    override fun onTextChanged(
        s: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) { /* Don't care */
    }

    private fun isEmail(str: String): Boolean {
        return str.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }

    private fun isPhone(str: String): Boolean {
        return str.isNotEmpty() && android.util.Patterns.PHONE.matcher(str).matches()
    }

}