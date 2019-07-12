package com.melayer.androidbatch11june.retrofitdemo.domain

import com.google.gson.annotations.SerializedName

data class CountryResponse(

		@field:SerializedName("result")
	val result: Result? = null,

		@field:SerializedName("message")
	val message: String? = null,

		@field:SerializedName("status")
	val status: String? = null
)