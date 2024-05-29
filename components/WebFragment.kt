package com.example.scribble

import android.os.Bundle
import android.view.View
import dev.hotwire.strada.BridgeDelegate
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination
import dev.hotwire.turbo.views.TurboWebView

class WebFragment : TurboWebFragment(), NavDestination {
  private val bridgeDelegate by lazy {
    BridgeDelegate(
      location = location,
      destination = this,
      componentFactories = bridgeComponentFactories
    )
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewLifecycleOwner.lifecycle.addObserver(bridgeDelegate)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    viewLifecycleOwner.lifecycle.removeObserver(bridgeDelegate)
  }

  override fun onColdBootPageStarted(location: String) {
    bridgeDelegate.onColdBootPageStarted()
  }

  override fun onColdBootPageCompleted(location: String) {
    bridgeDelegate.onColdBootPageCompleted()
  }

  override fun onWebViewAttached(webView: TurboWebView) {
    bridgeDelegate.onWebViewAttached(webView)
  }

  override fun onWebViewDetached(webView: TurboWebView) {
    bridgeDelegate.onWebViewDetached()
  }
}
