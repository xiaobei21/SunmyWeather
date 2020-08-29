package com.example.sunmyweather.logic

import androidx.lifecycle.liveData
import com.example.sunmyweather.logic.model.Place
import com.example.sunmyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/**
 * @ClassName Repository
 * @Describe Java类作用描述
 * @Author bql
 * @Version 当前版本号
 * @Date on 2020-08-28 13:38
 **/
object Repository {
    fun searchPlaces(query: String)  = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            }else
            {
                Result.failure<List<Place>>(RuntimeException("response status is  ${placeResponse.status}" ))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}