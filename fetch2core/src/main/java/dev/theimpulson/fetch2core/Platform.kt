package dev.theimpulson.fetch2core

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

object Platform {

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M)
    fun isMAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N)
    fun isNAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O)
    fun isOAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P)
    fun isPAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.Q)
    fun isQAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.R)
    fun isRAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.R
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    fun isSAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
    fun isTAndAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
    }

}