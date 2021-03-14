package com.arun.sampleapp.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arun.sampleapp.R
import com.arun.sampleapp.Ui.Model.SliderItemModel
import kotlinx.android.synthetic.main.activity_single_action.*

class SingleActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_action)
         var model = intent.getSerializableExtra("model") as SliderItemModel?
         initView(model)



    }

    private fun initView(data: SliderItemModel?) {
        inner_image.setImageResource(data!!.image)
        title_image.text =  data.title
        rate.text =  data.rate
        desc.text = data.desc

    }
}