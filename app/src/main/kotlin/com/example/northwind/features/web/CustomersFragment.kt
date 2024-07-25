package com.example.northwind.features.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import com.example.northwind.util.BASE_URL
import com.example.northwind.util.HOME_URL
import com.google.android.material.button.MaterialButton
import dev.hotwire.turbo.fragments.TurboFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "northwind://fragment/customers")
class CustomersFragment : TurboFragment(), NavDestination {
  lateinit var toolbar : androidx.appcompat.widget.Toolbar

  @SuppressLint("UseRequireInsteadOfGet")
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    toolbar = this.activity?.findViewById(R.id.toolbar)!!
    return inflater.inflate(R.layout.fragment_customers, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setButton(R.id.button_customers, "Customers")
    setButton(R.id.button_employees, "Employees")
    setButton(R.id.button_orders, "Orders")
    setButton(R.id.button_products, "Products")
    setButton(R.id.button_regions, "Regions")
    setButton(R.id.button_shippers, "Shippers")
    setButton(R.id.button_suppliers, "Suppliers")
  }

  private fun setButton(viewId: Int, text: String) {
    val buttonView = this.view?.findViewById<View>(viewId)
    val template = buttonView?.findViewWithTag<View>("button_template")
    val button = template as Button
    val url = "$BASE_URL/$text".lowercase()

    button.text = text
    button.setOnClickListener {
      navigate(url)
    }

  }

}