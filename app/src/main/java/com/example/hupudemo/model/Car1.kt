package com.example.hupudemo.model

import com.example.mvvmdemo.Api.ApiManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Car1(
    val is_trail: Int,
    val is_left: Int,
    val is_right: Int,
    val is_front: Int,
    val is_back: Int,
    val is_stop: Int,
    val is_fire: Int,
    val is_nofire: Int,
    val temperature: Int,
    val humidity: Int,
){

    fun loadInformation(){
        val baseUrl = ""
        var api = ApiManager.getInstance()?.getDailyService(baseUrl)
        GlobalScope.launch {
//            this@Car1 = api?.getCarInfo()
        }
    }

}