package com.arun.sampleapp.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.arun.sampleapp.R
import com.arun.sampleapp.Ui.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navigationView: BottomNavigationView
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            try {
                val frag: androidx.fragment.app.FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                when (item.itemId) {
                    R.id.navigation_home -> {
                        frag.replace(R.id.container, HomeFragment.newInstance("", ""))
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.explore -> {
                        frag.replace(R.id.container, HomeFragment.newInstance("", ""))
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.stdio -> {
                        frag.replace(R.id.container, HomeFragment.newInstance("", ""))
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }


                    R.id.profile -> {
                        frag.replace(R.id.container, HomeFragment.newInstance("", ""))
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }
                }
            } catch (ec: Exception) {
                ec.printStackTrace()
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationView = mNavigation
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance("", "")).commit()
    }
}