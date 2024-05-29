package com.example.scribble.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scribble.R
import dev.hotwire.strada.KotlinXJsonConverter
import dev.hotwire.strada.Strada
import dev.hotwire.turbo.activities.TurboActivity
import dev.hotwire.turbo.delegates.TurboActivityDelegate

class MainActivity : AppCompatActivity(), TurboActivity {
  override lateinit var delegate: TurboActivityDelegate

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)

    delegate = TurboActivityDelegate(this, R.id.main_nav_host)
  }

  private fun configStrada() {
    Strada.config.jsonConverter = KotlinXJsonConverter()
  } 
  
}
