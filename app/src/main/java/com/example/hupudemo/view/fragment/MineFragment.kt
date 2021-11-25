package com.example.hupudemo.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.hupudemo.R
import com.example.hupudemo.databinding.FragmentMineBinding
import com.example.hupudemo.view.activity.LoginActivity
import com.example.hupudemo.viewModel.MineFragmentViewModel

class MineFragment private constructor(): Fragment() ,View.OnClickListener{

    private val mineFragmentViewModel = MineFragmentViewModel()
    private lateinit var binding : FragmentMineBinding

    companion object {
        private lateinit var mineFragment : MineFragment
        fun getInstance() =
            if (!this::mineFragment.isInitialized){
                mineFragment = MineFragment()
                mineFragment
            }else mineFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMineBinding.inflate(LayoutInflater.from(activity))
        initClick()
        MineFragmentViewModel.isLogin.observe(this,{
            if (it == true){
                binding.dataLayout.visibility = View.VISIBLE
                binding.btnLogin.visibility = View.GONE
                binding.tvName.visibility = View.VISIBLE
                mineFragmentViewModel.apply {
                    getCarInfo()
                    getUserInfo(MineFragmentViewModel.name)
                }
                initData()

                mineFragmentViewModel.also { vm ->
                    vm.carInfo.observe(this,{
                        it?.is_fire.let { me ->
                            binding.fire.text = if (me == 1){
                                binding.fire.setBackgroundColor(Color.RED)
                                "WARNING"
                            }else {
                                binding.fire.setBackgroundColor(Color.GREEN)
                                "状态安全！"
                            }
                        }
                        binding.rain.text = it?.humidity.toString() + "°C"
                    })
                    vm.userInfo.observe(this,{
                        binding.time.text = it.time
                        binding.tvName.text = it.name
                        Glide.with(activity)
                            .load(it.pic)
                            .placeholder(R.drawable.load)  // 占位图
                            .error(R.drawable.error) // 异常加载占位图
                            .into(binding.pic)
                    })
                }
            }
            if (it == false){
                binding.dataLayout.visibility = View.INVISIBLE
                binding.btnLogin.visibility = View.VISIBLE
                binding.tvName.visibility = View.INVISIBLE
                Glide.with(activity)
                    .load(R.drawable.load)
                    .placeholder(R.drawable.load)  // 占位图
                    .error(R.drawable.error) // 异常加载占位图
                    .into(binding.pic)
            }


        })

//        var url = "https://img2.baidu.com/it/u=2237039644,3735368368&fm=26&fmt=auto"
//        Glide.with(activity)
//            .load(url)
//            .asBitmap()  //只允许加载静态图片   传入动图只显示第一帧，传入静态图片报错
//            .placeholder(R.drawable.load)  // 占位图
//            .diskCacheStrategy(DiskCacheStrategy.NONE)  //禁用Glide缓存的功能
//            .error(R.drawable.error) // 异常加载占位图
//            .into(binding.pic);
    }

    private fun initClick() {
        binding.btnLogin.setOnClickListener(this)
        binding.btnExit.setOnClickListener(this)
    }

    private fun initData() {
        var carInfo = mineFragmentViewModel.carInfo
        binding.fire.text = if (carInfo.value?.is_fire == 1) "着火了" else "没事"
        binding.rain.text = carInfo.value?.humidity.toString()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                var intent = Intent(activity,LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_exit -> {
                MineFragmentViewModel.isLogin.value = false
            }
        }
    }

}