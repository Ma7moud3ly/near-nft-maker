package com.near.labs.utils

import android.text.Editable

import android.widget.TextView

import android.text.TextWatcher
import com.near.labs.data.VER_TYPE


abstract class TextValidator(private val textView: TextView, private val type: VER_TYPE) : TextWatcher {
    abstract fun validate(valid: Boolean)
    override fun afterTextChanged(s: Editable) {
        val text = textView.text.toString()
        when (type) {
            VER_TYPE.EMAIL -> validate(isEmail(text))
            VER_TYPE.PHONE -> validate(isPhone(text))
            else -> validate(false)
        }
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