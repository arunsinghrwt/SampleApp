package com.arun.sampleapp.Ui.fragment

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.arun.sampleapp.R

import com.arun.sampleapp.Ui.Model.SliderItemModel
import com.arun.sampleapp.Ui.SingleActionActivity
import com.arun.sampleapp.Ui.adapter.ItemAdapter

import com.arun.sampleapp.Ui.adapter.SliderPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(),
    SliderPagerAdapter.OnClickTask {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var myView : View
    lateinit var itemlist : ArrayList<Int>

    var currentPage = 0
    var DELAY_MS: Long? = null
    var PERIOD_MS: Long? = null
    var timer: Timer? = null
    lateinit var sliderItemList : ArrayList<SliderItemModel>
    private var innerSliderViewPagerAdapter: SliderPagerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView =  inflater.inflate(R.layout.fragment_home, container, false)
        initView()
        return myView
    }

    private fun initView() {
        setData()
        sliderView()
        setAdapter()

    }



    private fun setAdapter() {
        innerSliderViewPagerAdapter = SliderPagerAdapter(requireContext(), sliderItemList)
        myView.sliderViewPager.adapter = innerSliderViewPagerAdapter
        myView.sliderViewPager.adapter  = innerSliderViewPagerAdapter.apply {
            this!!.addInterface(this@HomeFragment)
        }
        setUpAutoSlideTimer(itemlist.size)
        myView.ListRecyclerView.apply {
            adapter = ItemAdapter(itemlist, requireContext())
        }

    }

    private fun setUpAutoSlideTimer(NUM_PAGES: Int) {
        myView.pageIndicatorView.count = NUM_PAGES
        val handler = Handler(Looper.myLooper()!!)
        val runnable = Runnable {
            currentPage = if (currentPage == NUM_PAGES - 1) { 0
            } else {
                currentPage + 1
            }
            myView.pageIndicatorView.selection = currentPage
            myView.sliderViewPager.setCurrentItem(currentPage, true)
        }
        DELAY_MS = 800L
        PERIOD_MS = 4000L
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }
        }, DELAY_MS!!, PERIOD_MS!!)
    }


    private fun sliderView() {
        myView.sliderViewPager.clipToPadding = false
        myView.sliderViewPager.setPadding(30, 0, 30, 0)
        myView.sliderViewPager.pageMargin = 5
        myView.sliderViewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
            override fun onPageSelected(position: Int) {
                myView.pageIndicatorView.selection = position
            }
            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun setData() {
        itemlist = ArrayList<Int>()
        itemlist.add(0, R.drawable.new33)
        itemlist.add(1, R.drawable.new33)
        itemlist.add(2, R.drawable.new33)
        itemlist.add(3, R.drawable.new33)
        itemlist.add(4, R.drawable.new33)
        itemlist.add(5, R.drawable.new33)
        itemlist.add(6, R.drawable.new33)
        itemlist.add(7, R.drawable.new33)
        sliderItemList = ArrayList<SliderItemModel>().apply {
            this.add(0,SliderItemModel("883 Police Jacket","1500 Rs","Best New Arrival jacket" , R.drawable.ban1))
            this.add(1,SliderItemModel("Nike Sport Shoes","5000 Rs","Best New Arrival Nike Shoes" , R.drawable.ban4))
            this.add(2,SliderItemModel("Women Day Sale","500 - 6000 Rs","Best New Arrival Clothes For Women Day" , R.drawable.ban3))
            this.add(3,SliderItemModel("HRX Clothes","3000 Rs","Best New Arrival Rhx Brand Clothes" , R.drawable.ban2))

        }


    }
    override fun OnClickTask(itemModel: SliderItemModel) {

        var intent  = Intent(requireContext(), SingleActionActivity::class.java)
        intent.putExtra("model", itemModel)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation( requireActivity()).toBundle())
        } else {
            startActivity(intent)
        }
    }


}


