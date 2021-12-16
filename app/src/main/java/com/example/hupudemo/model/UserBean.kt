package com.example.hupudemo.model

import androidx.databinding.ObservableField

//ObservableDField 会自动刷新view 控件中的值
data class UserBean(
    var name : ObservableField<String>,
    var age : ObservableField<Int>
)