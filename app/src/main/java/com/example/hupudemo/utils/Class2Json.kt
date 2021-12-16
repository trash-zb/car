package com.example.hupudemo.utils

import com.example.hupudemo.model.Car
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser

object Class2Json {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val dataList = mutableListOf<Car>()
//        (1..10).forEach {
//            dataList.add(Task(it, "Task$it"))
//        }
//
//        var jsonString = formatJson(Gson().toJson(dataList))
//        copyToClipboard(jsonString)
//        System.out.println(jsonString)
//    }

    fun formatJson(content: String): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonParser = JsonParser()
        val jsonElement = jsonParser.parse(content)
        return gson.toJson(jsonElement)
    }

}
