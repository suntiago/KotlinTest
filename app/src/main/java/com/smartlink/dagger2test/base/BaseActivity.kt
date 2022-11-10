package com.smartlink.dagger2test.base

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    var lifeCycleDelegateList = arrayListOf<LifeCycleActivityDelegate>()
    fun addLifeCycleDelegate(lifeCycleActivityDelegate: LifeCycleActivityDelegate) {
        lifeCycleDelegateList.add(lifeCycleActivityDelegate)
    }

    fun removeLifeCycleDelegate(lifeCycleActivityDelegate: LifeCycleActivityDelegate) {
        lifeCycleDelegateList.remove(lifeCycleActivityDelegate)
    }

    override fun onStop() {
        super.onStop()
        lifeCycleDelegateList.forEach(LifeCycleActivityDelegate::onStop)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeCycleDelegateList.forEach { it.onCreate(savedInstanceState) }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        lifeCycleDelegateList.forEach { it.onNewIntent(intent) }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeCycleDelegateList.forEach(LifeCycleActivityDelegate::onDestroy)
    }

    override fun onRestart() {
        super.onRestart()
        lifeCycleDelegateList.forEach(LifeCycleActivityDelegate::onRestart)
    }

    override fun onStart() {
        super.onStart()
        lifeCycleDelegateList.forEach(LifeCycleActivityDelegate::onStart)
    }

    override fun onResume() {
        super.onResume()
        lifeCycleDelegateList.forEach(LifeCycleActivityDelegate::onResume)
    }

    override fun onPause() {
        super.onPause()
        lifeCycleDelegateList.forEach(LifeCycleActivityDelegate::onPause)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        lifeCycleDelegateList.forEach { it.onSaveInstanceState(outState) }
    }

    override fun onRestoreInstanceState(bundle: Bundle) {
        super.onRestoreInstanceState(bundle)
        lifeCycleDelegateList.forEach { it.onRestoreInstanceState(bundle) }
    }

    override fun onConfigurationChanged(configuration: Configuration) {
        super.onConfigurationChanged(configuration)
        lifeCycleDelegateList.forEach { it.onConfigurationChanged(configuration) }
    }
}