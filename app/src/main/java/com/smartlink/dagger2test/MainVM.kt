package com.smartlink.dagger2test

import android.app.Application
import android.util.Log
import android.widget.Toast
import javax.inject.Inject

/**
 * MainVM
 *
 * @author zaiyu
 * @description:
 * @date :2022/4/29 16:05
 */
class MainVM @Inject constructor(private val application: Application, private val string: String) {

    private val TAG = "MainVM"
    fun init() {
        Toast.makeText(application, "test dagger2", Toast.LENGTH_LONG).show();
        Log.d(TAG, "init: ")
    }
}