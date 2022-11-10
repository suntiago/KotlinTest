package com.smartlink.dagger2test.base.delegate

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smartlink.dagger2test.base.LifeCycleFragmentDelegate

class LogFragmentDelegate() : LifeCycleFragmentDelegate {
    private var TAG: String? = null

    constructor(tag: String) : this() {
        TAG = "LogDelegate:$tag --";
    }

    override fun onCreate(bundle: Bundle?) {
        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
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

    override fun onConfigurationChanged(configuration: Configuration) {
        Log.d(TAG, "onConfigurationChanged")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewStateRestored")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
    }

    override fun onAttach() {
        Log.d(TAG, "onAttach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        Log.d(TAG, "onCreateView")
    }
}