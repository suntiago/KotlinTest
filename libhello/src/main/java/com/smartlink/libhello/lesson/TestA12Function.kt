package com.smartlink.libhello.lesson

/**
 * 函数使用*/
class TestA12Function {

    fun test() {
        testExpand()
        funHighOrder("hello") { it.length }
        "kotlin" should Start with "kot"
        "kotlin".should(Start).with("kot")
    }

    /**
     * 高阶函数
     * */
    fun funHighOrder(a: String, callback: (String) -> Int) {
        var tt = callback(a)
        println("$a length is $tt")
    }

    fun testExpand() {
        var t: String = ""
        t.expand()
    }

    object Start

    /**
     * 拓展函数
     * */
    fun String.expand() {
        println("expand function")
    }

    /**
     * 拓展参数
     * */
    public var String.isowned: Boolean
        get() {
            return isowned
        }
        set(value) {
            isowned = value
        }

    //中缀表达式
    infix fun String.should(start: Start): String {
        return ""
    }

    //中缀表达式
    infix fun String.with(str: String): String = ""
}