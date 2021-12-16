package com.example.hupudemo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.hupudemo.databinding.ActivityControllerBinding

class CarControllerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityControllerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var b : Bundle
        super.onCreate(savedInstanceState)
        binding = ActivityControllerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}