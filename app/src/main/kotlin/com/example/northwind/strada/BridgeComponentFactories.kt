package com.example.northwind.strada

import dev.hotwire.strada.BridgeComponentFactory

val bridgeComponentFactories = listOf(
  // Must be the same name as the Stimulus static component
  BridgeComponentFactory("custom", ::CustomButton),
  BridgeComponentFactory("new", ::NewButton),
  BridgeComponentFactory("edit", ::EditButton),
  BridgeComponentFactory("save", ::SaveButton),
  BridgeComponentFactory("delete", ::DeleteButton),
  BridgeComponentFactory("link-to", ::LinkTo),
)