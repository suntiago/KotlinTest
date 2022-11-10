package com.smartlink.libhello.lesson

class Test6UnitIf {
    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            args.iterator().forEach { println(it) }

            var a = if (!args.isEmpty()) args.isEmpty() else 0
            println(a)
        }
    }

    fun f1():Unit{

    }
}