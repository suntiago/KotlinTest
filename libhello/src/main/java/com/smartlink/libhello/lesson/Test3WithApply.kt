package com.smartlink.libhello.lesson

class Test3WithApply {
    var var1: String? = null
        private set
        get

    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {

            var n: String = "tom"
            var a: String = "18"
            var g: String = "男"

            /**
             * apply 用法*/
            val person = Person().apply {
                name = n
                age = a
                gender = g
            }

            with(person) {
                n = name
                a = age
                g = gender
            }
            /**
             * run in self and return the block`s value
             * */
            val length = person.let { person.name.length }
            println("c1.r1 ${person.name} length is :$length")

            var info = ""

            /**
             * just run a block and return the block`s value
             * */
            info = run {
                "person run name:" + person.name + " ,age:" + person.age
            }

            /**
             * run in itself and return the block`s value
             * */
            person.run {
                printC1()
            }

            /**
             * run and return this
             * **/
            var nitself = n.also {
                println("a1 $it")
            }
            var ai = 1
            var bi = 2
            /**
             * run block and return this
             * */
            ai = bi.also { bi = ai }

            /**
             * judge itself and return this*/
            var tomPerson = person.takeIf {
                it.name == "tom" && it.age == "18"
            }

            var notTom = person.takeUnless {
                it.name == "tom"
            }

            repeat(10) {
                /*热烈欢迎10 次*/
                person.hello(it)
            }

            /*class Turtle {
                fun penDown()
                fun penUp()
                fun turn(degrees: Double)
                fun forward(pixels: Double)
            }

            val myTurtle = Turtle()
            with(myTurtle) { // 画一个 100 像素的正方形
                penDown()
                for (i in 1..4) {
                    forward(100.0)
                    turn(90.0)
                }
                penUp()
            }*/
        }
    }

    class Person {
        var name = ""
        var age = ""
        var gender = ""
        fun printC1() {
            println("Person name age gender:$name $age $gender")
        }

        fun hello(int: Int) {
            println("hello hello:$int")
        }
    }

}

