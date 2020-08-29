package com.example.sunmyweather.ui.place
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunmyweather.logic.Repository
import com.example.sunmyweather.logic.model.Place

/**
 * @ClassName PlaceViewModel
 * @Describe Java类作用描述
 * @Author bql
 * @Version 当前版本号
 * @Date on 2020-08-28 13:53
 **/
class PlaceViewModel : ViewModel(){
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData)
    { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}