package com.example.hupudemo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hupudemo.model.DataX
import com.example.hupudemo.model.IndexInfo
import com.example.mvvmdemo.Api.ApiManager
import com.example.mvvmdemo.Bean.Student
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.concurrent.ThreadLocalRandom


//继承  声明周期
class IndexFragmentViewModel : ViewModel(){

    private val baseUrl = "https://www.wanandroid.com"
    private val indexApi = ApiManager.getInstance()?.getDailyService(baseUrl)
    val indexInfo : MutableLiveData<IndexInfo> = MutableLiveData()

    fun getCarPostInfo(){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                    indexInfo.value = indexApi?.getCarPostInfo()
            }
        }
    }
}