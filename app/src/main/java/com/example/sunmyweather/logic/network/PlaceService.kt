package com.example.sunmyweather.logic.network

import com.example.sunmyweather.SunnyWeatherApplication
import com.example.sunmyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @ClassName PlaceService
 * @Describe Java类作用描述
 * @Author bql
 * @Version 当前版本号
 * @Date on 20200820 22:29
 **/
interface PlaceService {
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String):Call<PlaceResponse>
}