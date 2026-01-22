## Smart Disconnection Reminder
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![API](https://img.shields.io/badge/API-24%2B-orange)](#)
---

Smart Disconnection Reminder is a lightweight Android Kotlin library that monitors network connectivity (Wi-Fi / Mobile Data) and notifies your app when the device gets disconnected or reconnected.

It is designed to be simple, battery-efficient, and lifecycle-safe, making it ideal for apps that need to react to network loss (reminders, warnings, sync handling, etc.).

---

### Features

- Detects network connection & disconnection
- Works with Wi-Fi and Mobile Data
- Uses modern ConnectivityManager.NetworkCallback
- Lifecycle-friendly (start() / stop())
- No background services required
- Clean callback-based API
- Minimal permission

---

### Preview

<p align="center">
<table>
  <tr>
    <td align="center">
      <img src="assets/demo1.gif" width="360" />
    </td>
  </tr>
</table>
</p>


---

---

## Installation (JitPack)

### 1️⃣ Add JitPack to your **root `settings.gradle` or `build.gradle`**

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### Add Dependency
```
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_SmartDisconnectionReminder:1.0.0'
	}
```

---

### Quick Start

Initialize SmartDisconnect
```kotlin
val smartDisconnect = SmartDisconnect(
    context = this,
    callback = object : DisconnectCallback {
        override fun onNetworkStateChanged(state: NetworkState) {
            when (state) {
                NetworkState.CONNECTED -> {
                    // Network is available
                }
                NetworkState.DISCONNECTED -> {
                    // Network lost – show reminder
                }
            }
        }
    }
)
```

Start & Stop Listening
```kotlin
override fun onStart() {
    super.onStart()
    smartDisconnect.start()
}

override fun onStop() {
    super.onStop()
    smartDisconnect.stop()
}
```

### Required Permission

Add this permission to your app manifest:
```kotlin
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

---

### License

```
MIT License

Copyright (c) 2025 Excelsior Technologies 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
