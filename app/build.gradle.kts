plugins {
  id("com.android.application") version "8.4.1"
  id("org.jetbrains.kotlin.android") version "1.9.0"
}

android {
  namespace = "com.example.scribble"
  compileSdk = 34
  defaultConfig {
    minSdk = 34
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation("dev.hotwire:strada:1.0.0-beta3")
  implementation("dev.hotwire:turbo:7.1.3")
  implementation(platform("androidx.compose:compose-bom:2023.10.01"))
  // implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}
