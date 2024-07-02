package com.example.northwind.strada

import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import dev.hotwire.strada.BridgeComponent
import dev.hotwire.strada.BridgeDelegate
import dev.hotwire.strada.Message
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class LinkTo (
  name: String,
  private val delegate: BridgeDelegate<NavDestination>,
) : BridgeComponent<NavDestination>(name, delegate) {
  private val fragment: Fragment
    get() = delegate.destination.fragment
  private val toolbar: Toolbar?
    get() = fragment.view?.findViewById(R.id.toolbar)

  override fun onReceive(message: Message) {
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
    val menuProvider = object : MenuProvider {
      override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_link_to, menu)
        val menuItem = menu.findItem(R.id.menu_item)
        menuItem?.let {
          it.title = data.title
        }
      }

      override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
          R.id.menu_item -> {
            return replyTo("connect")
          }
          else -> false
        }
      }
    }

    toolbar?.removeMenuProvider(menuProvider as MenuProvider)
    toolbar?.addMenuProvider(menuProvider as MenuProvider)
  }

  @Serializable
  data class MessageData(
    // Must be the same name as the argument passed to the send method of the Stimulus controller
    @SerialName("title") val title: String
  )
}
