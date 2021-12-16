package com.example.hupudemo.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.*

fun Test01() {
//    val liveData = MutableLiveData<Int>()
//    liveData.observe(this, Observer { count ->
//        println(l)
//    })


}

fun main() {
    println("hello")
}

suspend fun pirntHello(){
    //launch {  }  报错，这儿不在写协程的作用域中
    coroutineScope {
        launch {
            for (i in 1..10){
                println(i)
                delay(1000)
            }
        }
    }
}



