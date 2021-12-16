package com.example.hupudemo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hupudemo.api.ApiManagerBetter
import com.example.hupudemo.model.Car
import com.example.hupudemo.model.Mine
import com.example.hupudemo.utils.Class2Json
import com.example.mvvmdemo.Api.ApiManager
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine

class MineFragmentViewModel {

//    private val baseUrl = "http://601c5lcj.dongtaiyuming.net:80"
    private val baseUrl = "http://172.16.48.56:8080"
    private val api = ApiManager.getInstance()?.getDailyService(baseUrl)
    private val job = Job()
    private val socpe = CoroutineScope(job)
    var isSuccess = MutableLiveData<Boolean>()
    var carInfo = MutableLiveData<Car?>()
    var userInfo = MutableLiveData<Mine>()

    companion object {
        var isLogin = MutableLiveData<Boolean>()
        var name = ""
        fun isLoginFun(){
            isLogin.value = true
        }
    }
    init {
        sendFromAndroid()
    }


    private fun <T> MutableLiveData<T>.request(res : T?){
        socpe.launch {
            withContext(Dispatchers.Main){
                value = res
            }
        }
    }

    suspend fun getCarInfo02(){
        carInfo.request(api?.getCarInfo())
    }

    fun getCarInfo01(){

    }

    fun getCarInfo(){
        socpe.launch{
            withContext(Dispatchers.Main){
                carInfo.value = api?.getCarInfo()
            }
        }
    }


    fun login(username : String,password : String){
        socpe.launch {
            withContext(Dispatchers.Main){
                isSuccess.value = api?.login(username, password) ?: false
            }
        }
    }

    fun getUserInfo(username: String){
        socpe.launch {
            withContext(Dispatchers.Main){
                try {
                    val result = api?.getUserInfo(username)
                    Log.i("XXX", "userInfo is $result")
                    userInfo.value = result ?: null
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
    }

    fun sendFromAndroid(){
        var car = Car(0,0,0,0,0,0,0,0, 0.0F,0.0F)
        var json = Class2Json.formatJson(Gson().toJson(car))
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                try {
                    api?.sendFromAndroid(json)
                    Log.i("XXX", "fdhjgsf $json")
                }catch(e : Exception) {
                    e.printStackTrace()
                    Log.i("XXX", "sendFromAndroid: ")
                }

            }
        }
    }





}

