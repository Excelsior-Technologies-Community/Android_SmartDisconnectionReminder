package com.ext.smartdisconnect

import android.content.Context

class SmartDisconnect(
    context: Context,
    callback: DisconnectCallback
) {

    private val observer = NetworkObserver(
        context.applicationContext,
        callback
    )

    fun start() {
        observer.register()
    }

    fun stop() {
        observer.unregister()
    }
}
