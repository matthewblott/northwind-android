package com.example.scribble

import dev.hotwire.strada.BridgeComponentFactory

val bridgeComponentFactories = listOf(
  BridgeComponentFactory("form", ::FormComponent),
)
