package com.example.hupudemo.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hupudemo.R
import com.example.hupudemo.databinding.FragmentIndexBinding
import com.example.hupudemo.databinding.ItemIndexBinding
import com.example.hupudemo.model.DataX
import com.example.hupudemo.view.utils.RecycleAdapter
import com.example.hupudemo.viewModel.IndexFragmentViewModel
import com.example.hupudemo.viewModel.MineFragmentViewModel
import kotlin.math.log

class IndexFragment public constructor(): Fragment(){
    private val TAG = "XXX"
    private lateinit var binding : FragmentIndexBinding
    private var indexFragmentViewModel = IndexFragmentViewModel()
    private var dataXList = mutableListOf<DataX>()


    companion object{
        private lateinit var indexFragment : Fragment
        fun getInstance() =
            if (!this::indexFragment.isInitialized){
                indexFragment = IndexFragment()
                indexFragment
            }else indexFragment

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        indexFragmentViewModel.indexInfo.observe(this,{
            binding.indexBar.visibility = View.INVISIBLE
            dataXList.clear()
            dataXList.addAll(it.data.datas)
            Log.i(TAG, "刷新了 ${dataXList.toString()}")
            var a = binding.recycleView.adapter
            Log.i(TAG, if (a == null) "空的" else "有东西啊")
            a?.notifyDataSetChanged()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIndexBinding.inflate(LayoutInflater.from(activity))
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        indexFragmentViewModel.getCarPostInfo()
        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            Log.i(TAG, dataXList.toString())
            Log.i(TAG, "indexinfo ${indexFragmentViewModel.indexInfo.value.toString()}")
            adapter = RecycleAdapter(dataXList)
            this.adapter?.notifyDataSetChanged()
        }
    }

}