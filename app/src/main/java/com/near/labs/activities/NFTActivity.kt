package com.near.labs.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.near.labs.R
import com.near.labs.databinding.ActivityNftBinding


class NFTActivity : AppCompatActivity() {
    lateinit var binding: ActivityNftBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val host = supportFragmentManager.findFragmentById(R.id.nav_host_nft) as NavHostFragment
        binding.footer.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            try {
                when (item.itemId) {
                    R.id.home -> {
                        host.navController.navigate(R.id.home)
                    }
                    R.id.add -> {
                        host.navController.navigate(R.id.addNFTFragment)
                    }
                    R.id.send -> {
                        host.navController.navigate(R.id.sendNFTFragment)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            true
        }

    }
}