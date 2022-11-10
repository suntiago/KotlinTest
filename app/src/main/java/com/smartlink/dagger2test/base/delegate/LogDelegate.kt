package com.smartlink.dagger2test.base.delegate

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import com.smartlink.dagger2test.base.LifeCycleActivityDelegate

class LogDelegate() : LifeCycleActivityDelegate {
    private var TAG: String? = null

    constructor(tag: String) : this() {
        TAG = "LogDelegate:$tag";
    }

    override fun onCreate(bundle: Bundle?) {
        Log.d(TAG, "onCreate")
    }

    override fun onNewIntent(intent: Intent?) {
        Log.d(TAG, "onNewIntent")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
    }

    override fun onSaveInstanceState(bundle: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(bundle: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
    }

    override fun onConfigurationChanged(configuration: Configuration) {
        Log.d(TAG, "onConfigurationChanged")
    }
}