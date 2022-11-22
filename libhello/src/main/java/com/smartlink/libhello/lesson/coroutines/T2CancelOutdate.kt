package com.smartlink.libhello.lesson.coroutines

import kotlinx.coroutines.*

/**
 *
 * 取消与超时
 */
class T2CancelOutdate {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                try {
                    repeat(1000) {
                        println("repeat times $it")
                        delay(100)
                    }
                } finally {
                    println("repeat delay 100")
                    delay(1000)
                }

            }
            delay(1300)
            println("job cancel")
            job.cancel()
            println("job canceled")
            println("job join")
            job.join()
            println("job joined")
            //job.cancelAndJoin()

            /*超时*/
            withTimeout(1000) {
                repeat(100) {
                    println("withtimeout repeat")
                    delay(100)
                }
            }
        }
    }
}