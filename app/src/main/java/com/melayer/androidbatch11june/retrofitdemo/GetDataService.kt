package com.melayer.androidbatch11june.retrofitdemo

import com.melayer.androidbatch11june.retrofitdemo.domain.Country
import com.melayer.androidbatch11june.retrofitdemo.domain.CountryResponse
import retrofit2.Call
import retrofit2.http.*

interface GetDataService {

    @POST("master/country/addCountry")
    fun addCountry(@Header("Authorization") token: String, @Body country: Country):Call<CountryResponse>


    @GET("master/country/getCountry")
    fun getCountry(@Header("Authorization") token: String, @Query("id")id:Long):Call<CountryResponse>

}