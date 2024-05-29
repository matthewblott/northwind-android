package com.example.scribble

import android.webkit.WebView
import androidx.fragment.app.Fragment
import dev.hotwire.strada.Bridge
import dev.hotwire.strada.Strada
import dev.hotwire.turbo.config.Turbo
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
  override val sessionName = "main"
  override val startLocation = "http://10.0.2.2:3000/"
//  override val startLocation = "http://192.168.0.233:3000/"
  override val registeredFragments: List<KClass<out Fragment>>
    get() = listOf(
      WebFragment::class
    )

  override fun onSessionCreated() { 
    super.onSessionCreated()

    // Initialize the user agent
    session.webView.settings.userAgentString = session.webView.customUserAgent

    // Initialize Strada bridge with new WebView instance
    Bridge.initialize(session.webView) 
  } 
  
  override val pathConfigurationLocation: TurboPathConfiguration.Location
    get() = TurboPathConfiguration.Location(    
          assetFilePath = "json/configuration.json",
//          remoteFileUrl = "http://192.168.0.233:3000/configurations/android.json"
        )

  // Build a custom user agent string. Be careful to continue to include 
  // the "Turbo Native" substring as part of the user agent.
  private val WebView.customUserAgent: String
    get() {
      val turboSubstring = Turbo.userAgentSubstring()
      val stradaSubstring = Strada.userAgentSubstring(bridgeComponentFactories)
      return "$turboSubstring; $stradaSubstring; ${settings.userAgentString}"
    } 
  
}
