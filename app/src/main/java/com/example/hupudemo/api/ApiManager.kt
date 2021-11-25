package com.example.mvvmdemo.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    private var mDailyApi : WanAndroidApi? = null
    companion object {
        private var apiManager : ApiManager? = null
        private var preBaseUrl : String? = ""
        fun getInstance() : ApiManager?{
            synchronized(Object()){
                if (apiManager == null) {
                    apiManager = ApiManager()
                }
            }
            return apiManager
        }
    }

    fun getDailyService(baseUrl : String) : WanAndroidApi?{
        var okHttpClient = OkHttpClient.Builder()
            .build()
        if (preBaseUrl != baseUrl){
            var retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
            mDailyApi = retrofit.create(WanAndroidApi::class.java)
        }
        return mDailyApi
    }
}


