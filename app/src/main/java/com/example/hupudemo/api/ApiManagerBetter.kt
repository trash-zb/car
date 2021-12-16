package com.example.hupudemo.api

import com.example.mvvmdemo.Api.WanAndroidApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManagerBetter {

    private var baseUrl : String = ""

    fun <T> getInstance(baseUrl : String,clazz: Class<T>) : T {
        this.baseUrl = baseUrl
        return create(clazz)
    }

    private fun <T> create(clazz : Class<T>) : T{
        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(clazz)
    }
}