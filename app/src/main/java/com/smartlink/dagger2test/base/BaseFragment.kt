package com.smartlink.dagger2test.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    init {
        Log.d("LogDelegate Fragment ", "init")
    }
    var lifeCycleDelegateList = arrayListOf<LifeCycleFragmentDelegate>()
    fun addLifeCycleDelegate(lifeCycleFragmentDelegate: LifeCycleFragmentDelegate) {
        lifeCycleDelegateList.add(lifeCycleFragmentDelegate)
    }

    fun removeLifeCycleDelegate(lifeCycleFragmentDelegate: LifeCycleFragmentDelegate) {
        lifeCycleDelegateList.remove(lifeCycleFragmentDelegate)
    }

    override fun onStop() {
        super.onStop()
        lifeCycleDelegateList.forEach(LifeCycleFragmentDelegate::onStop)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeCycleDelegateList.forEach { it.onCreate(savedInstanceState) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifeCycleDelegateList.forEach { it.onViewCreated(view, savedInstanceState) }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifeCycleDelegateList.forEach { it.onCreateView(inflater, container, savedInstanceState) }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onDestroy() {
        super.onDestroy()
        lifeCycleDelegateList.forEach(LifeCycleFragmentDelegate::onDestroy)
    }

    override fun onStart() {
        super.onStart()
        lifeCycleDelegateList.forEach(LifeCycleFragmentDelegate::onStart)
    }

    override fun onResume() {
        super.onResume()
        lifeCycleDelegateList.forEach(LifeCycleFragmentDelegate::onResume)
    }

    override fun onPause() {
        super.onPause()
        lifeCycleDelegateList.forEach(LifeCycleFragmentDelegate::onPause)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        lifeCycleDelegateList.forEach { it.onSaveInstanceState(outState) }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        lifeCycleDelegateList.forEach { it.onViewStateRestored(savedInstanceState) }
    }

    override fun onConfigurationChanged(configuration: Configuration) {
        super.onConfigurationChanged(configuration)
        lifeCycleDelegateList.forEach { it.onConfigurationChanged(configuration) }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        lifeCycleDelegateList.forEach { it.onAttach() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifeCycleDelegateList.forEach { it.onActivityCreated(savedInstanceState) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifeCycleDelegateList.forEach { it.onDestroyView() }
    }

    override fun onDetach() {
        super.onDetach()
        lifeCycleDelegateList.forEach { it.onDetach() }
    }
}