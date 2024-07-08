package com.example.northwind.strada

import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.northwind.R
import com.example.northwind.base.NavDestination
import com.example.northwind.databinding.ButtonCustomBinding
import com.example.northwind.databinding.ButtonOverflowBinding
import dev.hotwire.strada.BridgeComponent
import dev.hotwire.strada.BridgeDelegate
import dev.hotwire.strada.Message
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class CustomButton(
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
    val menu = toolbar?.menu ?: return
    val inflater = LayoutInflater.from(fragment.requireContext())
    val binding = ButtonCustomBinding.inflate(inflater)

    binding.buttonCustom.text = data.title
    binding.buttonCustom.apply {
      setOnClickListener {
        performSubmit()
      }
    }

    menu.removeItem(3)
    menu.add(0, 3, 0, data.title).apply {
      actionView = binding.root
      setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
    }

  }

  private fun performSubmit(): Boolean {
    return replyTo("connect")
  }

  @Serializable
  data class MessageData(
    // Must be the same name as the argument passed to the send method of the Stimulus controller
    @SerialName("title") val title: String
  )
}
