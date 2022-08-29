package com.example.shopprojectuni.data

import com.google.gson.annotations.SerializedName

data class ResponseGeneralCat(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String
)
