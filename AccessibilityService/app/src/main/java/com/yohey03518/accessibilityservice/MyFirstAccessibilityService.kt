package com.yohey03518.accessibilityservice

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class MyFirstAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // Handle the accessibility event
        Log.d("yohey", "debug message")
        Log.e("yohey", "error message")
        Log.i("yohey", "info message")
        Log.w("yohey", "warn message")
    }

    override fun onInterrupt() {
        // Handle the interrupt
    }
}
