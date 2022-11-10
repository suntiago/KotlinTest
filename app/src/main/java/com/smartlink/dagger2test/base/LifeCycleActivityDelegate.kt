package com.smartlink.dagger2test.base

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle

interface LifeCycleActivityDelegate {
    fun onCreate(bundle: Bundle?) {}
    fun onNewIntent(intent: Intent?) {}
    fun onDestroy() {}
    fun onRestart() {}
    fun onStart() {}
    fun onStop() {}
    fun onResume() {}
    fun onPause() {}
    fun onSaveInstanceState(bundle: Bundle) {}
    fun onRestoreInstanceState(bundle: Bundle) {}
    fun onConfigurationChanged(configuration: Configuration) {}
}