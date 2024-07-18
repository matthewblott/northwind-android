package com.example.northwind.features.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import com.google.android.material.button.MaterialButton
import dev.hotwire.turbo.fragments.TurboFragment
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "northwind://fragment/numbers")
class NumbersFragment : TurboFragment(), NavDestination {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_numbers, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView(view)
  }

  private fun initView(view: View) {
    val button1 = view.findViewById<MaterialButton>(R.id.button1)

    button1.setOnClickListener {
//       navigateBack()
      navigate("http://10.0.2.2:45678")
    }
  }
}
