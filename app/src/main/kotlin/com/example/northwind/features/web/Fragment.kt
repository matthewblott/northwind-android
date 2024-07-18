package com.example.northwind.features.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "northwind://fragment/web/home")
open class Fragment : TurboWebFragment(), NavDestination {
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    val url = arguments?.getString(ARG_URL)
//    // Handle the URL, if needed
//  }

//  lateinit var toolbar : androidx.appcompat.widget.Toolbar

  @SuppressLint("UseRequireInsteadOfGet")
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//    toolbar = this.activity?.findViewById(R.id.toolbar)!!
    return inflater.inflate(R.layout.fragment, container, false)
  }
}
