package com.ext.smartdisconnect

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

class NetworkObserver(
    private val context: Context,
    private val callback: DisconnectCallback
) {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            callback.onNetworkStateChanged(
                com.ext.smartdisconnect.model.NetworkState.CONNECTED
            )
        }

        override fun onLost(network: Network) {
            callback.onNetworkStateChanged(
                com.ext.smartdisconnect.model.NetworkState.DISCONNECTED
            )
        }
    }

    fun register() {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    fun unregister() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}
