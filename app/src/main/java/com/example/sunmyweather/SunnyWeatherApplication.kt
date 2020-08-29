package com.example.sunmyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.security.AccessControlContext

/**
 * @ClassName SunnyWeatherApplication
 * @Describe Java类作用描述
 * @Author bql
 * @Version 当前版本号
 * @Date on 20200820 22:06
 **/
class SunnyWeatherApplication :Application(){
    companion object{
//        @SuppressLint("StaticFiledLeak")
        lateinit var context: Context
        const val TOKEN = "QytouqCamOnZZaYF"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}