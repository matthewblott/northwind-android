package com.example.scribble

import android.util.Log
import dev.hotwire.strada.BridgeComponent
import dev.hotwire.strada.BridgeDelegate
import dev.hotwire.strada.Message
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class FormComponent(
  name: String,
  private val delegate: BridgeDelegate<NavDestination>
) : BridgeComponent<NavDestination>(name, delegate) {
  
  override fun onReceive(message: Message) {
    when (message.event) {
      "connect" -> handleConnectEvent(message)
      "submitEnabled" -> handleSubmitEnabled()
      "submitDisabled" -> handleSubmitDisabled()
      else -> Log.w("TurboDemo", "Unknown event for message: $message")
    } 
  }

  private fun handleConnectEvent(message: Message) {
//    val data = message.data<MessageData>() ?: return 
    // Write native code to display a native submit button in the 
    // toolbar displayed in the delegate.destination. Use the 
    // incoming data.title to set the button title. The 
    // implementation depends on how your app is structured. 
  }
  
  private fun handleSubmitEnabled() {
    // Write code to enable the submit button.
  }

  private fun handleSubmitDisabled() {
    // Write code to disable the submit button.
  }
  
  private fun showToolbarButton(data: MessageData) {
    
  } 
  
  // Reply to the originally received "connect" event message (without any new data).
  private fun performSubmit(): Boolean {
    return replyTo("connect")
  }
  
  @Serializable
  data class MessageData(
    @SerialName("submitTitle") val title: String
  ) 
}
