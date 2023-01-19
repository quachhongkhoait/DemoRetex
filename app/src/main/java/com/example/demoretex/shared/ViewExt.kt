package com.example.demoretex.shared

import android.os.SystemClock
import android.view.View

/**
 * Prevent fast click on a [View].
 */
fun View.safeClick(blockInMillis: Long = 1000L, onClick: (View) -> Unit) {
    var lastClickTime: Long = 0
    setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) return@setOnClickListener
        lastClickTime = SystemClock.elapsedRealtime()
        onClick(this)
    }
}