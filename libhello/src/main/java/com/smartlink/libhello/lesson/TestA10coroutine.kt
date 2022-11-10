package com.smartlink.libhello.lesson

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * coroutineTest
 *
 * @author zaiyu
 * @description:
 * @date :2022/10/29 8:57
 */
class TestA10coroutine {
    fun sus() {
        GlobalScope.launch {
            val arg1 = coroutine1()
            var arg2 = coroutine2()
            println(arg1)
            println(arg2)
        }
    }

    suspend fun coroutine1(): Int {
        println("coroutine1 start")
        delay(1)
        println("coroutine1 end")
        return 1
    }

    suspend fun coroutine2(): Int {
        println("coroutine2 start")
        delay(1)
        println("coroutine2 end")
        return 2
    }

}