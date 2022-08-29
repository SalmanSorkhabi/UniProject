package com.example.shopprojectuni.data

import com.google.gson.annotations.SerializedName

data class ResponseBanner(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("type")
	val type: String
)
