package com.smartlink.libhello.lesson

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Conditional
 *
 * @author zaiyu
 * @description:
 * @date :2022/8/8 20:22
 */
class Test9Conditional {
    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            val FLAG_IN_USE = 1 shl 0
            var flags = 0

            println(flags and FLAG_IN_USE === FLAG_IN_USE)

            Test9Conditional().run { ifnotnull() }
        }
    }

    /**
     * //变量为空，则空执行 ?:
     * */
    fun ifnotnull() {
        val a = ""
        a ?: println("a is null")
        a?.let {
            println("a is not null")
        } ?: println("a is null")
    }

    /**
     * is 类型判断
     * */
    fun ifis(a: Any) {
        if (a is String) {
            println("is String")
        } else if (a is Boolean) {
            println("is Boolean")
        }
    }



    fun conditional(a: Int): String {
        return when {
            a > 0 -> "$a a > 0"
            a == 0 -> "$a a == 0"
            else -> "$a a < 0"
        }
    }

    fun conditional2(a: Int): String {
        return if (a > 0) {
            "$a a > 0"
        } else if (a == 0) {
            "$a a == 0"
        } else {
            "$a a < 0"
        }
    }

    fun conditional3(a: Int): String =
        if (a > 0) {
            "$a a > 0"
        } else if (a == 0) {
            "$a a == 0"
        } else {
            "$a a < 0"
        }


}