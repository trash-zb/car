package com.example.hupudemo.utils

import android.widget.Toast
import com.example.hupudemo.MyApplication

fun String.showToast(){
    Toast.makeText(MyApplication.context,this,Toast.LENGTH_SHORT).show()
}