package com.arun.sampleapp.Ui.adapter

import android.content.Context
import android.view.*
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.arun.sampleapp.R
import com.arun.sampleapp.Ui.Model.SliderItemModel
import kotlinx.android.synthetic.main.slider_layout.view.*
import java.util.*


/**
// Created by Arun Singh Rawat on 14-03-2021.



 **/

class SliderPagerAdapter(context: Context, slideList: ArrayList<SliderItemModel>) :
    PagerAdapter() {
    var list = slideList

    var context: Context = context
    var onClickTask: OnClickTask? = null
    interface OnClickTask {
        fun OnClickTask(loanList: SliderItemModel)
    }
    fun addInterface(onClickTask: OnClickTask) {
        this.onClickTask = onClickTask
    }
    var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = layoutInflater.inflate(R.layout.slider_layout, container, false)
        itemView.imageView_inner.setActualImageResource(list[position].image)
        itemView.imageView_inner.setOnClickListener {
            onClickTask!!.OnClickTask(list[position])
        }
        container.addView(itemView)
        return itemView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout?)
    }






}