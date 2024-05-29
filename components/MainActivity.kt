package com.example.scribble

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.hotwire.strada.KotlinXJsonConverter
import dev.hotwire.strada.Strada
import dev.hotwire.turbo.activities.TurboActivity
import dev.hotwire.turbo.delegates.TurboActivityDelegate

class MainActivity : AppCompatActivity(), TurboActivity {
  override lateinit var delegate: TurboActivityDelegate 
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    configStrada() 

    setContentView(R.layout.activity_main)

     ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {
       v, insets ->
         val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
         v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
         insets
     }
  }
  private fun configStrada() {
    Strada.config.jsonConverter = KotlinXJsonConverter()
  } 
  
}
