package com.example.northwind.strada

import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import com.example.northwind.databinding.ButtonEditBinding
import com.example.northwind.databinding.ButtonOverflowBinding
import dev.hotwire.strada.BridgeComponent
import dev.hotwire.strada.BridgeDelegate
import dev.hotwire.strada.Message
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class EditButton(
  name: String,
  private val delegate: BridgeDelegate<NavDestination>,
) : BridgeComponent<NavDestination>(name, delegate) {

  private val fragment: Fragment
    get() = delegate.destination.fragment
  private lateinit var toolbar : Toolbar

  override fun onReceive(message: Message) {
    if(fragment is com.example.northwind.features.web.Fragment) {
      val foo = fragment as com.example.northwind.features.web.Fragment
      toolbar = foo.toolbar
    }

    when (message.event) {
      "connect" -> handleConnectEvent(message)
      else -> Log.w("TurboDemo", "Unknown event for message: $message")
    }
  }

  private fun handleConnectEvent(message: Message) {
    val data = message.data<MessageData>() ?: return
    showToolbarButton(data)
  }

  private fun showToolbarButton(data: MessageData) {
//    val menu = toolbar?.menu ?: return
//    val inflater = LayoutInflater.from(fragment.requireContext())
//    val binding = ButtonEditBinding.inflate(inflater)
//
//    binding.buttonEdit.apply {
//      setOnClickListener {
//        performSubmit()
//      }
//    }
//
//    menu.removeItem(0)
//    menu.add(0, 0, 0, data.title).apply {
//      actionView = binding.root
//      setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
//    }

    val menuProvider = object : MenuProvider {
      override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        val item: MenuItem? = menu.findItem(R.id.menu_edit_item)

        if(item != null ) {
          menu.removeItem(R.id.menu_edit_item)
        }

        menuInflater.inflate(R.menu.menu_edit, menu)

//        menu.clear()
//        menuInflater.inflate(R.menu.menu_edit, menu)
      }

      override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
          R.id.menu_edit_item -> {
            return replyTo("connect")
          }
          else -> false
        }
      }
    }



//    toolbar.removeMenuProvider(menuProvider as MenuProvider)
    toolbar.addMenuProvider(menuProvider, fragment.getViewLifecycleOwner(), Lifecycle.State.RESUMED)

  }

  private fun performSubmit(): Boolean {
    return replyTo("connect")
  }

  @Serializable
  data class MessageData(
    // This must be the same name as the variable being passed in the stimulus controller
    @SerialName("title") val title: String
  )
}
