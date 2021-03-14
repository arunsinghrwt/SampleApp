package com.arun.sampleapp.Ui

import androidx.multidex.MultiDexApplication
import com.facebook.drawee.backends.pipeline.Fresco


/**
// Created by Arun Singh rawat on 14-03-2021.



 **/

class BaseApplication : MultiDexApplication()  {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

}