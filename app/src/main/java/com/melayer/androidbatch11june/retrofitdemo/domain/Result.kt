package com.melayer.androidbatch11june.retrofitdemo.domain

import com.google.gson.annotations.SerializedName

data class Result(

	@field:SerializedName("new")
	val jsonMemberNew: Boolean? = null,

	@field:SerializedName("countryDescription")
	val countryDescription: String? = null,

	@field:SerializedName("activeStatus")
	val activeStatus: String? = null,

	@field:SerializedName("countryCode")
	val countryCode: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("countryName")
	val countryName: String? = null
)