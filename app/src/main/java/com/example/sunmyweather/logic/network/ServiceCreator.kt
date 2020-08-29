package com.example.sunmyweather.logic.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @ClassName ServiceCreator
 * @Describe Java类作用描述
 * @Author bql
 * @Version 当前版本号
 * @Date on 20200820 22:34
 **/
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"


    val loggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor(
        HttpLoggingInterceptor.Logger {
            //打印retrofit日志
            Log.i("RetrofitLog","retrofitBack = "+it.toString());
        }
    ).setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(20000, TimeUnit.SECONDS)
        .readTimeout(20000, TimeUnit.SECONDS)
        .writeTimeout(20000, TimeUnit.SECONDS)
        .build();
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline fun <reified T> create() :T = create(T::class.java)
}