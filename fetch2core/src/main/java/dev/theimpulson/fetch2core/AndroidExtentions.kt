@file:JvmName("FetchAndroidExtensions")

package dev.theimpulson.fetch2core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

@Suppress("DEPRECATION")
fun Context.isOnWiFi(): Boolean {
    val manager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Platform.isMAndAbove()) {
        val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
        if (capabilities != null) {
            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
        return false
    } else {
        val activeNetworkInfo = manager.activeNetworkInfo
        return if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI
        } else {
            false
        }
    }
}

fun Context.isOnMeteredConnection(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.isActiveNetworkMetered
}

@Suppress("DEPRECATION")
fun Context.isNetworkAvailable(): Boolean {
    val manager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Platform.isMAndAbove()) {
        val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            ) {
                return true
            }
        }
        return false
    } else {
        val activeNetworkInfo = manager.activeNetworkInfo
        var connected = activeNetworkInfo != null && activeNetworkInfo.isConnected
        if (!connected) {
            connected = manager.allNetworkInfo.any { it.isConnected }
        }
        return connected
    }
}