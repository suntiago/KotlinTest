package com.smartlink.libhello.lesson.coroutines

import kotlinx.coroutines.*

/**
 * T1Helloworld
 *
 * @author zaiyu
 * @description:
 * @date :2022/11/14 20:48
 *
 * 用这个函数不会阻塞当前调用的线程。这对 UI 编程是非常有用的，
 * 因为 UI 的主线程需要不断相应各种图形绘制、用户操作的请求，
 * 如果主线程上有耗时操作会让其他请求无法及时响应，造成 UI 卡顿
 *
 * 这相比 callback 和 RxJava 的 API 是要好很多的。这些异步的 API 最终都得依靠回调，
 * 但回调回来在哪个线程需要调用方自己搞清楚，得看这些函数里面是怎么实现的。
 * 而有了 suspend 不阻塞当前线程的约定，调用方其实无须关心这个函数内部是在哪个线程执行的。
 */
class T1HelloWorld {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            T1HelloWorld().run {
                test1()
                test2()
            }
            println("main sleep " + Thread.currentThread().name)
            Thread.sleep(5000L)
            println("main sleep 5s " + Thread.currentThread().name)
        }
    }


    fun test1(): Job {
        val job = GlobalScope.launch {
            //这是因为 delay 是一个特殊的 挂起函数 ，
            //它不会造成线程阻塞，但是会 挂起 协程，并且只能在协程中使用。
            delay(1000L)
            println("test1 World! " + Thread.currentThread().name)
        }
        println("test1 Hello, " + Thread.currentThread().name)
        return job
    }

    fun test2(): Job = runBlocking {
        val job = GlobalScope.launch {
            //这是因为 delay 是一个特殊的 挂起函数 ，
            //它不会造成线程阻塞，但是会 挂起 协程，并且只能在协程中使用。
            delay(8000L)
            println("test2 World! " + Thread.currentThread().name)
            foo()
        }
        println("test2 Hello, " + Thread.currentThread().name)
        delay(2000L)
        println("test2 Hello 2000L, " + Thread.currentThread().name)
        job
    }

    /**
     * suspend 可挂起的标志
     * */
    suspend fun foo() {
        println("foo wait  1s " + Thread.currentThread().name)
        delay(1000L)
        println("foo wait 1s after " + Thread.currentThread().name)
    }
}