package com.example.hupudemo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hupudemo.model.DataX
import com.example.hupudemo.model.IndexInfo
import com.example.mvvmdemo.Api.ApiManager
import com.example.mvvmdemo.Bean.Student
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.concurrent.ThreadLocalRandom

class IndexFragmentViewModel {

    private val baseUrl = "https://www.wanandroid.com"
    private val indexApi = ApiManager.getInstance()?.getDailyService(baseUrl)
    val indexInfo : MutableLiveData<IndexInfo> = MutableLiveData()

    fun getCarPostInfo(){
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                try {
                    val result = Result.success(indexApi?.getCarPostInfo())
                    indexInfo.value = result.getOrNull()
                    Log.i("XXX", "xiecheng: ${indexInfo.value.toString()}")
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }

        }
    }



}