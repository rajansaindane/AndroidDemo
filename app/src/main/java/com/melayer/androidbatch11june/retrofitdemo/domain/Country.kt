package com.melayer.androidbatch11june.retrofitdemo.domain

import com.google.gson.annotations.SerializedName

data class Country(

	@field:SerializedName("countryDescription")
	var countryDescription: String? = null,

	@field:SerializedName("countryCode")
	var countryCode: String? = null,

	@field:SerializedName("countryName")
	var countryName: String? = null
)