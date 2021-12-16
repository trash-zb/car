package com.example.mvvmdemo.Interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LogInterceptor : Interceptor {

    val TAG = "LogInterceptor"

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var response = chain.proceed(request)
        Log.i(TAG, "request -> $request")
        Log.i(TAG, "response -> $response")
        return response
    }
}