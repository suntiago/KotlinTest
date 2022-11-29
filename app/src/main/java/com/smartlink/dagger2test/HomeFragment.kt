package com.smartlink.dagger2test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.smartlink.dagger2test.base.BaseFragment
import com.smartlink.dagger2test.base.delegate.LogFragmentDelegate
import com.smartlink.dagger2test.databinding.HomeFragemntBinding

class HomeFragment : BaseFragment() {
    init {
        addLifeCycleDelegate(LogFragmentDelegate("HomeFragment"))
    }

    lateinit var binding: HomeFragemntBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<HomeFragemntBinding>(
            inflater,
            R.layout.home_fragemnt,
            container,
            false
        ).apply {
            lifecycleOwner = this@HomeFragment
            //setVariable(id, object)
        }
        return binding.root
    }
}