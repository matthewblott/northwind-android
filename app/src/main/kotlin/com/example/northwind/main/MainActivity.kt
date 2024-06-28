package com.example.northwind.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.northwind.R
import com.example.northwind.databinding.ActivityMainBinding
import dev.hotwire.strada.KotlinXJsonConverter
import dev.hotwire.strada.Strada
import dev.hotwire.turbo.activities.TurboActivity
import dev.hotwire.turbo.delegates.TurboActivityDelegate

class MainActivity : AppCompatActivity(), TurboActivity {
  override lateinit var delegate: TurboActivityDelegate
  private lateinit var binding: ActivityMainBinding
  private lateinit var navController: NavController
  private lateinit var appBarConfiguration: AppBarConfiguration

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)

    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

    val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment

    navController = navHostFragment.navController

    appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
    setupActionBarWithNavController(navController)

    delegate = TurboActivityDelegate(this, R.id.main_nav_host)
    Strada.config.jsonConverter = KotlinXJsonConverter()

  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp(appBarConfiguration)
        || super.onSupportNavigateUp()
  }

}

