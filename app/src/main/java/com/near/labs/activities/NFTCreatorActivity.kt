package com.near.labs.activities

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.near.labs.R
import com.near.labs.databinding.ActivityNftCreatorBinding


class NFTCreatorActivity : BaseActivity() {
    lateinit var binding: ActivityNftCreatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNftCreatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val host = supportFragmentManager.findFragmentById(R.id.nav_host_nft_creator) as NavHostFragment

        transparentStatusBar(findViewById(R.id.nft_creator_layout))


    }
}