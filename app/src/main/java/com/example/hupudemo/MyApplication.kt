package com.example.hupudemo

import android.app.Application
import android.content.Context


//可以在全局的任何调用 MyApplication.context 获取实例
class MyApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}