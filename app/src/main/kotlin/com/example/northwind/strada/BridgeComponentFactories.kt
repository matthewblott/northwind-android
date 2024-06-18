package com.example.northwind.strada

import dev.hotwire.strada.BridgeComponentFactory

val bridgeComponentFactories = listOf(
  BridgeComponentFactory("edit", ::EditButton),
  BridgeComponentFactory("save", ::SaveButton),
  BridgeComponentFactory("delete", ::DeleteButton),
)
