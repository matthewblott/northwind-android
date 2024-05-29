package com.example.scribble

import dev.hotwire.strada.BridgeDestination
import dev.hotwire.turbo.nav.TurboNavDestination

interface NavDestination : TurboNavDestination, BridgeDestination {

  override fun bridgeWebViewIsReady(): Boolean {
    return session.isReady
  }
}
