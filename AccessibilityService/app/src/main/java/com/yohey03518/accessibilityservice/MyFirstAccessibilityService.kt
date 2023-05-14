package com.yohey03518.accessibilityservice

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class MyFirstAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        val rootNode = rootInActiveWindow
        val content = exploreNodeInfo(rootNode)
        Log.d("yohey", content)
        Log.e("yohey", "error message")
        Log.i("yohey", "info message")
        Log.w("yohey", "warn message")
    }

    override fun onInterrupt() {
        // Handle the interrupt
    }

    private fun exploreNodeInfo(nodeInfo: AccessibilityNodeInfo): String {
        var content = "";
        if (!nodeInfo.text.isNullOrEmpty()) {
            content += "," + nodeInfo.text
        }
        for (i in 0 until nodeInfo.childCount) {
            val childNode = nodeInfo.getChild(i)
            if (childNode != null) {
                content += "," + exploreNodeInfo(childNode)
            }
        }
        return content
    }
}
