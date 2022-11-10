package com.smartlink.libhello.lesson


class Test1Varl {
    var var1: String? = null
        private set
        get

    val lazyP by lazy {
        println("")
         "123123"
    }

    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            val FLAG_IN_USE = 1 shl 0
            var flags = 0
            println("hello world")
            val v = Test1Varl()
            println("end")
            println(flags and FLAG_IN_USE === FLAG_IN_USE)
            println(v.lazyP)
        }
    }

    fun valvar() {
        val t1 = ""
        val t2: String = ""
        var t3: String?
        t3 = null
    }

}