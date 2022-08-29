package com.example.shopprojectuni.data

import com.google.gson.annotations.SerializedName

data class ResponsePopularProduct(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("id")
	val id: Int
)
