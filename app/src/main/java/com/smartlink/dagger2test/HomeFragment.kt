package com.smartlink.dagger2test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smartlink.dagger2test.base.BaseFragment

import com.smartlink.dagger2test.base.delegate.LogFragmentDelegate

class HomeFragment : BaseFragment() {
    init {
        addLifeCycleDelegate(LogFragmentDelegate("HomeFragment"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragemnt, null)
    }
}