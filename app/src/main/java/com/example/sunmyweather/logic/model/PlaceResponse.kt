package com.example.sunmyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @ClassName Place
 * @Describe Java类作用描述
 * @Author bql
 * @Version 当前版本号
 * @Date on 2020-08-20 22:19
 **/
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String ,val location :Location ,
                 @SerializedName("formatted_address") val address:String)

data class Location(val lng:String,val lat:String)
