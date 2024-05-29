package com.example.scribble.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import com.example.scribble.features.web.WebFragment
import com.example.scribble.features.web.WebHomeFragment
import com.example.scribble.util.HOME_URL
import kotlin.reflect.KClass

class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
  override val sessionName = "main"
  override val startLocation = HOME_URL
 
  override val registeredFragments: List<KClass<out Fragment>>
    get() = listOf(
      WebFragment::class,
      WebHomeFragment::class
    )

  override val registeredActivities: List<KClass<out AppCompatActivity>>
    get() = listOf()

  override val pathConfigurationLocation: TurboPathConfiguration.Location
    get() = TurboPathConfiguration.Location(assetFilePath = "json/configuration.json")
}
