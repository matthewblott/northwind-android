package com.example.scribble.features.web

import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/web/home")
open class WebHomeFragment : TurboWebFragment()
