package com.example.mvvmdemo.Bean

const val a = 14

class Student {

    var id : String = ""
    var name : String = "zhangbao"
    var credit : Double = 0.00
    var password : String = ""

    constructor(
        id : String,
        name : String,
        credit : Double,
        password : String
    )

    constructor()

    override fun toString(): String {
        return "Student(id='$id', name='$name', credit=$credit, password='$password')"
    }

    fun test(){
        println("被代理对象正在执行")
    }
}