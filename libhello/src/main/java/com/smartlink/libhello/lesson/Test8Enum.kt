package com.smartlink.libhello.lesson

class Test8Enum {
    enum class DayOfWeek(val int: Int) {
        MON(1),
        TUE(2);

        fun getDay() = int
    }

    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            var a = 0
            var s = when (a) {
                0 -> "0"
                1 -> "12"
                else -> ""
            }
            println(s)
            val log1 = (Math.log(20.0) / Math.log(50.0)).toFloat()
            println(log1)
        }
    }
}