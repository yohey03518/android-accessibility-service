# Step 0
- Install Android Studio
- Install emulator device

# Create New Project
- Select *Phone and Tablet* and choose *Empty Activity*.
- Enter project name and package name.
- Choose SDK version lower than the target device.

# Create Accessibility Service 
- In the project view, right click package (com.yohey03518.accessibilityservice) > *New* > *Service* > *Service*.
- Enter name and select language (this project uses Kotlin, click Finish).
- In the new `MyFirstAccessibilityService`, extend from `AccessibilityService` and override two methods.
```
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
```
- Add below code in `AndroidManifest.xml`
```
<service android:name=".MyFirstAccessibilityService"
         android:permission="android.permission.BIND_ACCESSIBILITY_SERVICE">
    <intent-filter>
        <action android:name="android.accessibilityservice.AccessibilityService" />
    </intent-filter>
    <meta-data android:name="android.accessibilityservice"
               android:resource="@xml/accessibility_service_config" />
</service>
```
- Create config file `accessibility_service_config.xml` under `/res/xml` and use text editor to enter below content.
```
<?xml version="1.0" encoding="utf-8"?>
<accessibility-service xmlns:android="http://schemas.android.com/apk/res/android"
    android:accessibilityEventTypes="typeViewClicked|typeViewFocused"
    android:accessibilityFeedbackType="feedbackSpoken"
    android:accessibilityFlags="flagIncludeNotImportantViews"
    android:canRetrieveWindowContent="true"
    android:description="@string/accessibility_service_description"
    android:notificationTimeout="100"
    android:packageNames="com.example.yourpackagename"
    android:settingsActivity="com.example.android.apis.accessibility.TestBackActivity" />
```
`android:packageNames` is the name for the target app. If removing this setting, the accessibility service will apply to all app on the device. (Use *,* to separate multiple apps)
Press Alt+Enter on `@string/accessibility_service_description` to create your description.

After this step, you should be able to see the new accessibility service on the device > *Setting* > *Accessibility* and be able to turn it on.





