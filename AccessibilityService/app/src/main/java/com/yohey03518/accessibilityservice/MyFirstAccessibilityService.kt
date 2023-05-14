package com.yohey03518.accessibilityservice

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class MyFirstAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // Handle the accessibility event
    }

    override fun onInterrupt() {
        // Handle the interrupt
    }
}
