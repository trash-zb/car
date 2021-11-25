package com.example.hupudemo.view.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.hupudemo.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hupudemo.model.DataX
import com.example.hupudemo.model.IndexInfo
import com.example.hupudemo.view.activity.IndexDetailsActivity
import kotlin.coroutines.coroutineContext


class RecycleAdapter(var dataXList : List<DataX>) :
    RecyclerView.Adapter<RecycleAdapter.RecylcleViewHolder>() {


    class RecylcleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAuthor : TextView = itemView.findViewById(R.id.item_author)
        val tvTitle : TextView = itemView.findViewById(R.id.item_title)
        val tvNiceData : TextView = itemView.findViewById(R.id.nice_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylcleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_index, parent, false)
        return RecylcleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataXList.size
    }

    override fun onBindViewHolder(holder: RecylcleViewHolder, position: Int) {
        var dataX = dataXList[position]
        holder.apply {
            tvAuthor.text = dataX.author
            tvNiceData.text = dataX.niceDate
            tvTitle.text = dataX.title
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,IndexDetailsActivity::class.java)
            intent.putExtra("myUrl",dataX.link)
            it.context.startActivity(intent)
       }

    }

}



//class RecycleAdapter(var dataXList : String) :
//    RecyclerView.Adapter<RecycleAdapter.RecylcleViewHolder>() {
//
//
//    class RecylcleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val tvAuthor : TextView = itemView.findViewById(R.id.tv_author)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylcleViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_index, parent, false)
//        return RecylcleViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return 10
//    }
//
//    override fun onBindViewHolder(holder: RecylcleViewHolder, position: Int) {
//        holder.tvAuthor.text = "fdsfsd"
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }
//
//}


