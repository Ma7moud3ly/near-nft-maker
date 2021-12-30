package com.near.labs.activities

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.near.labs.R


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        transparentStatusBar(findViewById(R.id.main_layout))


    }
}