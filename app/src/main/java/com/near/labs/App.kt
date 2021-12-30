package com.near.labs

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        private const val TAG = "HINT"
        fun log(o: String) {
            Log.v(TAG, o.toString())
        }
    }
}
