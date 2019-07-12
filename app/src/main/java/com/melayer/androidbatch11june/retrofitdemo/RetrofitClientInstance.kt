package com.melayer.androidbatch11june.retrofitdemo

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class RetrofitClientInstance {

    companion object{
        private var retrofit: Retrofit? = null
        private val BASE_URL = "http://192.168.15.120:9191/api/"

        fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }


    }

}