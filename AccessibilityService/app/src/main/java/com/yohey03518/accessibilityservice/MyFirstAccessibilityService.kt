package com.yohey03518.accessibilityservice

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class MyFirstAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        val rootNode = rootInActiveWindow
        val content = exploreNodeInfo(rootNode)
        Log.d("yohey", content)
        Log.d("yohey", rootNode.packageName.toString())
        Log.e("yohey", "error message")
        Log.i("yohey", "info message")
        Log.w("yohey", "warn message")

        post("test")
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

    private fun post(content: String) {
        val client = OkHttpClient()
        val requestBody = content.toRequestBody("text/plain".toMediaTypeOrNull())
        val request = Request.Builder()
            .url("https://webhook.site/xxxx")
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                Log.d("Erwin", response.message)
            }
        })
    }

}
