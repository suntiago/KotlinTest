package com.smartlink.dagger2test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.smartlink.dagger2test.MainApplication
import com.smartlink.dagger2test.R
import com.smartlink.dagger2test.base.BaseActivity
import com.smartlink.dagger2test.base.delegate.LogDelegate
import com.smartlink.dagger2test.databinding.ActivityMainBinding
import com.smartlink.dagger2test.ui.main.MainVM
import javax.inject.Inject

class MainActivity : BaseActivity() {
    init {
        addLifeCycleDelegate(LogDelegate("MainActivity"))
    }

    @Inject
    lateinit var vm: MainVM

    @Inject
    lateinit var inflater: LayoutInflater
    private var fragment: HomeFragment = HomeFragment()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).component.inject(this)
        binding = ActivityMainBinding.inflate(inflater).apply {
            btnClick.setOnClickListener {
                show()
                vm.init()
                binding.btnClick.visibility = View.INVISIBLE
            }
        }
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().run {
            add(R.id.fl_content, fragment, "HomeFragment").commitAllowingStateLoss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.apply {
            btnClick.setOnClickListener(null)
        }
    }

    private fun show() {
        supportFragmentManager.beginTransaction().run {
            show(fragment)
            commit()
        }
    }

}