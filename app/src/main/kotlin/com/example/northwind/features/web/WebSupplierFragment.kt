package com.example.northwind.features.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import com.example.northwind.strada.bridgeComponentFactories2
import dev.hotwire.strada.BridgeDelegate
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination
import dev.hotwire.turbo.views.TurboWebView

@TurboNavGraphDestination(uri = "turbo://fragment/web/supplier")
open class WebSupplierFragment : TurboWebFragment(), NavDestination {
  private val bridgeDelegate by lazy {
    BridgeDelegate(
      location = location,
      destination = this,
      componentFactories =  bridgeComponentFactories2
    )
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_web_supplier, container, false)
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