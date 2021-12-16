package com.example.mvvmdemo.Api

import com.example.hupudemo.model.Car
import com.example.hupudemo.model.Data
import com.example.hupudemo.model.IndexInfo
import com.example.hupudemo.model.Mine
import com.example.mvvmdemo.Bean.Student
import com.example.mvvmdemo.Bean.WeatherData
import retrofit2.Call
import retrofit2.http.*

interface WanAndroidApi {

    @GET("/article/list/1/json")
    suspend fun getCarPostInfo() : IndexInfo

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(@Field("username")username : String, @Field("password")password : String) : Boolean

    @GET("/sqx_send")
    suspend fun getCarInfo() : Car

    @GET("/getUserInfo")
    suspend fun getUserInfo(@Query("username")username: String) : Mine

    @GET("/sendFromAndroid")
    suspend fun sendFromAndroid(@Query("data") data : String)

    @FormUrlEncoded
    @POST("/sendFromAndroid01")
    suspend fun sendFromAndroid01(@Body data : Car)

    @GET("/article/list/1/json")
    fun getInfo() : Call<Car>
}