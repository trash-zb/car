package com.example.hupudemo.model;

import androidx.annotation.Keep

@Keep
data class Verified(
    val msg: String? = "",
    val result: Result? = null,
    val status: Int? = null
)

@Keep
data class Result(
    val btnNo: String? = "",
    val btnYes: String? = "",
    val title: String? = "",
    val url: String? = ""
)