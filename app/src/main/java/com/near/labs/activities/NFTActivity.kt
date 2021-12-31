package com.near.labs.activities

import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.near.labs.R
import com.near.labs.databinding.ActivityNftBinding


class NFTActivity : BaseActivity() {
    lateinit var binding: ActivityNftBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nftUser.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val host = supportFragmentManager.findFragmentById(R.id.nav_host_nft) as NavHostFragment
        binding.footer.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            try {
                when (item.itemId) {
                    R.id.home -> {
                        host.navController.navigate(R.id.NFTHome)
                    }
                    R.id.add -> {
                        true
                    }
                    R.id.hisotry -> {
                        host.navController.navigate(R.id.NFTHistory)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            true
        }

    }
}