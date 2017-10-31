package com.javahe.kotlindemo.utils

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.javahe.kotlindemo.loge
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by zfc on 2017/10/31.
 */
class RetrofitUtils<T> {
    companion object {
        /**
         * 创建retrofit
         */
        fun create(url: String): Retrofit {
            //显示日志级别
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            /**lamada 表达式
             */
            val logInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> loge("RetrofitUtils", "Okhttp :" + message)
            })
            logInterceptor.level = level
            //创建OkhttpBuilder
            val okhttpClientBuilder = OkHttpClient().newBuilder()
            okhttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            okhttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(okhttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        val retrofitService: RetrofitService = RetrofitUtils.getService(Constant.REQUEST_BASE_URL, RetrofitService::class.java)

        /**
         * 获取ServiceApi
         */
        fun <T> getService(url: String, service: Class<T>): T {
            return create(url).create(service)
        }
    }
}