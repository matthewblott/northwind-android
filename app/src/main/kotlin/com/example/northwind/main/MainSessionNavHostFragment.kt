package com.example.northwind.main

import com.example.northwind.features.web.Fragment as Fragment
import com.example.northwind.features.web.HomeFragment
import com.example.northwind.features.web.NumbersFragment
import dev.hotwire.strada.Bridge
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
  override val sessionName = "main"
  override val startLocation = "http://10.0.2.2:45678/numbers"
//  override val startLocation = "http://10.0.2.2:45678/numbers"
//  override val startLocation = "http://10.0.2.2:45678/one"

  override val registeredFragments: List<KClass<out androidx.fragment.app.Fragment>>
    get() = listOf(
      Fragment::class,
      HomeFragment::class,
      NumbersFragment::class,
    )

  override val pathConfigurationLocation: TurboPathConfiguration.Location
    get() = TurboPathConfiguration.Location(
      assetFilePath = "json/configuration.json"
    )

  override fun onSessionCreated() {
    super.onSessionCreated()
    Bridge.initialize(session.webView)
  }

//  override fun onSessionCreated() {
//    super.onSessionCreated()
//
//    val turboSubstring = Turbo.userAgentSubstring()
//    val stradaSubstring = Strada.userAgentSubstring(bridgeComponentFactories)
//    val customerUserAgent = "$turboSubstring; $stradaSubstring; ${session.webView.settings.userAgentString}"
//
//    session.webView.settings.userAgentString = customerUserAgent
//    Bridge.initialize(session.webView)
//  }
}