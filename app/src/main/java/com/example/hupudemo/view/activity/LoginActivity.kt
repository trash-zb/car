package com.example.hupudemo.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.hupudemo.databinding.ActivityLoginBinding

import com.example.hupudemo.viewModel.MineFragmentViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    var mineFragmentViewModel = MineFragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        mineFragmentViewModel.isSuccess.observe(this,{
            if (it == true){
                //等待框消失
                binding.loadingBar?.visibility = View.INVISIBLE
                window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username",binding.username.text)
                MineFragmentViewModel.apply {
                    isLoginFun()
                    name = binding.username.text.toString()
                }
                startActivity(intent)
            }else{
                binding.loadingBar?.visibility = View.INVISIBLE
                window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                Toast.makeText(this,"账号或密码错误请重新登录！",Toast.LENGTH_SHORT).show()
            }


        })
        binding.login.setOnClickListener {
            var username = binding.username.text.toString()
            var password = binding.password.text.toString()
            binding.loadingBar?.visibility = View.VISIBLE
            window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            mineFragmentViewModel.login(username,password)
        }
    }
}