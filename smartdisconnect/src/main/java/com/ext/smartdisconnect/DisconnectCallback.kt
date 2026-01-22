package com.ext.smartdisconnect

import com.ext.smartdisconnect.model.NetworkState

interface DisconnectCallback {
    fun onNetworkStateChanged(state: NetworkState)
}