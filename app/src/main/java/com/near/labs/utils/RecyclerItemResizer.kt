package com.near.labs.utils

import android.app.Activity
import android.util.DisplayMetrics
import android.view.View

class RecyclerItemResizer {
    companion object{
        fun fitScreen(view:View){
            val context = view.context
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            view.layoutParams.width = displayMetrics.widthPixels
            view.layoutParams.height = (displayMetrics.widthPixels * 0.5).toInt()
        }
    }
}