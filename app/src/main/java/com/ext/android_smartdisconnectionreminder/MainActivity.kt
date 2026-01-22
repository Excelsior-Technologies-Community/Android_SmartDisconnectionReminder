package com.ext.android_smartdisconnectionreminder

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.smartdisconnect.SmartDisconnect
import com.ext.smartdisconnect.model.NetworkState
import com.ext.smartdisconnect.DisconnectCallback

class MainActivity : AppCompatActivity() {
    private lateinit var smartDisconnect: SmartDisconnect
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        smartDisconnect = SmartDisconnect(
            context = this,
            callback = object : DisconnectCallback {
                override fun onNetworkStateChanged(state: NetworkState) {
                    when (state) {
                        NetworkState.CONNECTED -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Network Connected",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        NetworkState.DISCONNECTED -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Network Disconnected 🚨",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            })
    }

    override fun onStart() {
        super.onStart()
        smartDisconnect.start()
    }

    override fun onStop() {
        super.onStop()
        smartDisconnect.stop()
    }
}