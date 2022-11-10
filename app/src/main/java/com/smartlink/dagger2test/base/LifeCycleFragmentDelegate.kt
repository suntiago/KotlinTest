package com.smartlink.dagger2test.base

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * LifeCycleFragmentDelegate
 *
 * @author zaiyu
 * @description:
 * @date :2022/5/13 10:15
 */
interface LifeCycleFragmentDelegate {
    fun onCreate(bundle: Bundle?) {}
    fun onNewIntent(intent: Intent?) {}
    fun onDestroy() {}
    fun onRestart() {}
    fun onStart() {}
    fun onStop() {}
    fun onResume() {}
    fun onPause() {}
    fun onSaveInstanceState(bundle: Bundle) {}
    fun onConfigurationChanged(configuration: Configuration) {}
    fun onViewStateRestored(savedInstanceState: Bundle?)
    fun onActivityCreated(savedInstanceState: Bundle?)
    fun onDestroyView()
    fun onDetach()
    fun onAttach()
    fun onViewCreated(view: View, savedInstanceState: Bundle?)
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
}