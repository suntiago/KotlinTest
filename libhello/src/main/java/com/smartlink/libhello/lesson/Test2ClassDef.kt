package com.smartlink.libhello.lesson

/**
 * Test2
 *
 * @author zaiyu
 * @description:
 * @date :2022/6/7 14:46
 */
class Test2ClassDef {
    fun test() {
        println("test2 fun")
    }

    /**
     * inner
     * 内部类使用 inner 关键字来表示。
     * 内部类会带有一个对外部类的对象的引用，
     * 所以内部类可以访问外部类成员属性和成员函数。
     * */
    internal inner class Inner() {
        fun f() {
            test()
        }
    }

    interface Flyer {
        var speed: Int
        fun fly() {
            println("fly")
        }
    }

    class Bird(override var speed: Int = 1) : Flyer {
        init {
            this.speed = speed
        }
    }

    interface CallBack {
        fun cal1()
        fun cal2()
    }
}