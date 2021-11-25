package com.example.hupudemo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hupudemo.model.Car
import com.example.hupudemo.model.Mine
import com.example.mvvmdemo.Api.ApiManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MineFragmentViewModel {

    private val baseUrl = "http://601c5lcj.dongtaiyuming.net:80"
    private val api = ApiManager.getInstance()?.getDailyService(baseUrl)
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


    fun getCarInfo(){
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                try {
                    val result = api?.getCarInfo()
                    carInfo.value = result
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }

        }
    }

    fun login(username : String,password : String){
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                try {
                    val result = api?.login(username, password)
                    isSuccess.value = result ?: false
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
    }

    fun getUserInfo(username: String){
        GlobalScope.launch {
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





}