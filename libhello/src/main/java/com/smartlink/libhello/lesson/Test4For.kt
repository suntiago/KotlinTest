package com.smartlink.libhello.lesson

class Test4For {
    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            println("rangeto")
            for (i in 1..10) {
                println(i)
            }
            println("townto")
            loop@ for (i in 10 downTo 2 step 2) {
                println(i)
                break@loop
            }
            var isin = "a" in listOf("1", "a", "b")
            println("isin : $isin")
            var i = 10
            var x = 10
            for (i in 1..100) {
            }  // 闭区间：包含 100
            for (i in 1 until 100) {
            } // 半开区间：不包含 100
            for (x in 2..10 step 2) {
            }
            for (x in 10 downTo 1) {
            }
            if (x in 1..10) {
            }


        }
    }

}