package com.example.hupudemo.view.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class FragmentAdapter(private val fragmentList: List<Fragment>,
                      val  fragmentManager : FragmentManager,
                      val lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment { return fragmentList[position]}

}