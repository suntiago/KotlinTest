package com.smartlink.libhello.lesson

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 内联 ： inline
 * 不内联 ：noinline
 * 内联，但是消除流程控制的影响 ：crossinline
 * */
class TestA11Inline {

    fun test() {
        inlin {
            var a = 2
        }

        println("---------------")

        noinlin {
            var a = 3
        }

        println("---------------")

        inlinnocross {
            var a = 4
        }
    }

    inline fun inlin(crossinline block: () -> Unit) {
        var a = 1
        a.let {
            a = 2
            GlobalScope.launch {
                block()
            }
        }
    }

    fun noinlin(block: () -> Unit) {
        var a = 1
        a.let {
            a = 2
            GlobalScope.launch {
                block()
            }
        }
    }

    /**
     * test inline parm without crossinline*/
    inline fun inlinnocross(block: () -> Unit) {
        var a = 1
        a.let {
            a = 2
            GlobalScope.launch {
                //block()
                return@launch
            }
        }
    }
}