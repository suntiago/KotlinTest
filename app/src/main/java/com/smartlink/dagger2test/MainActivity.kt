package com.smartlink.dagger2test

import android.os.Bundle
import android.view.View
import com.smartlink.dagger2test.base.BaseActivity
import com.smartlink.dagger2test.base.delegate.LogDelegate
import com.smartlink.libhello.lesson.Test1Varl
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
    init {
        addLifeCycleDelegate(LogDelegate("MainActivity"))
    }

    @Inject
    lateinit var vm: MainVM
    var fragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).component.inject(this)
        setContentView(R.layout.activity_main)
        btn_click.setOnClickListener {
            show()
            vm.init()
            btn_click.setVisibility(View.INVISIBLE)
        }
        if (fragment == null) {
            fragment = HomeFragment()
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_content, fragment!!, "HomeFragment").commitAllowingStateLoss()
        var a :Test1Varl = Test1Varl()
        a.sus()
    }

    fun show() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.show(fragment!!)
        transaction.commit()
    }

}