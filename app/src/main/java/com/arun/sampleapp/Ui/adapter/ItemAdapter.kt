package com.arun.sampleapp.Ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arun.sampleapp.R
import kotlinx.android.synthetic.main.item_raw_layout.view.*
import java.util.ArrayList


/**
// Created by Arun singh rawat on 13-03-2021.



 **/

class ItemAdapter(var itemList: ArrayList<Int>, var mContext: Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val itemLayoutView = LayoutInflater.from(mContext)
            .inflate(R.layout.item_raw_layout, null)
        return ViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemView.imageView.setImageResource(item)

    }

    override fun getItemCount(): Int {
       return itemList.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}