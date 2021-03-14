package com.arun.sampleapp.Ui.Model

import java.io.Serializable


/**
// Created by Arun Singh Rawat  on 13-03-2021.



 **/

class SliderItemModel(title: String?, rate: String?, desc: String? , image : Int?): Serializable{
     var title: String = title!!
     var rate: String = rate!!
     var desc: String = desc!!
     var image: Int = image!!

}