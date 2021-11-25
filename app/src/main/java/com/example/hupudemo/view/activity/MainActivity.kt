package com.example.hupudemo.view.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.hupudemo.R
import com.example.hupudemo.view.fragment.IndexFragment
import com.example.hupudemo.view.fragment.MineFragment
import com.example.hupudemo.databinding.ActivityMainBinding
import com.example.hupudemo.view.utils.FragmentAdapter
import com.example.hupudemo.viewModel.IndexFragmentViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    private val TAG = "XXX"
    private lateinit var mDataBindind : ActivityMainBinding
    private var fragmentList = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBindind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mDataBindind.root)
        mDataBindind.bottomBar.bringToFront()
        initFragment()
        initSetClick()
        mDataBindind.viewPager2.adapter = FragmentAdapter(fragmentList,supportFragmentManager,lifecycle)
        mDataBindind.bottomBar.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.bottom_bar_index -> mDataBindind.viewPager2.currentItem = 0
                R.id.bottom_bar_mine -> mDataBindind.viewPager2.currentItem = 1
            }
            true
        }
        mDataBindind.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> mDataBindind.bottomBar.menu.getItem(0).isChecked = true
                    else -> mDataBindind.bottomBar.menu.getItem(position + 1).isChecked = true
                }
            }
        })

    }

    private fun initFragment() {
        fragmentList.add(IndexFragment.getInstance())
//        var bundle = Bundle()
//        bundle.putString("username",intent.getStringExtra("username").toString())
//        Log.i(TAG, "initFragment:  ${intent.getStringExtra("username").toString()}")
//        var mineFragment = MineFragment.getInstance()
//        mineFragment.arguments = bundle
        Log.i(TAG, "initFragment: ")
        fragmentList.add(MineFragment.getInstance())
    }
    
    private fun initSetClick() {
        mDataBindind.btnCar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_car -> Log.i(TAG, "onC")
        }
    }


}