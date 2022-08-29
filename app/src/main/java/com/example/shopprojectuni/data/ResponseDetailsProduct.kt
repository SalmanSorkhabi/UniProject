package com.example.shopprojectuni.data

import com.google.gson.annotations.SerializedName

data class ResponseDetailsProduct(

	@field:SerializedName("comment_count")
	val commentCount: String,

	@field:SerializedName("seller")
	val seller: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("seller_image")
	val sellerImage: String,

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("score")
	val score: Double,

	@field:SerializedName("garanty_description")
	val garantyDescription: String,

	@field:SerializedName("seller_name")
	val sellerName: String,

	@field:SerializedName("price")
	val price: String,

	@field:SerializedName("cat_id")
	val catId: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("seller_id")
	val sellerId: Int,

	@field:SerializedName("similar")
	val similar: List<SimilarItem>,

	@field:SerializedName("off_price")
	val offPrice: String,

	@field:SerializedName("images")
	val images: List<ImageItemItem>,

	@field:SerializedName("comments")
	val comments: List<CommentsItem>,

	@field:SerializedName("subcat_name")
	val subcatName: String,

	@field:SerializedName("cat_name")
	val catName: String,

	@field:SerializedName("sub_id")
	val subId: String,

	@field:SerializedName("product_size")
	val productSize: List<ProductSizeItem>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("product_colors")
	val productColors: List<ProductColorsItem>,

	@field:SerializedName("off_percent")
	val offPercent: String,

	@field:SerializedName("properties")
	val properties: List<PropertiesItem>,

	@field:SerializedName("status")
	val status: String
)

data class CommentsItem(

	@field:SerializedName("name_family")
	val nameFamily: String,

	@field:SerializedName("comment_date")
	val commentDate: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("content")
	val content: String
)

data class PropertiesItem(

	@field:SerializedName("value")
	val value: String,

	@field:SerializedName("property_name")
	val propertyName: String
)

data class ProductSizeItem(

	@field:SerializedName("size_name")
	val sizeName: String,

	@field:SerializedName("size_id")
	val sizeId: String
)

data class SimilarItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("url")
	val url: String
)

data class ImageItemItem(

	@field:SerializedName("image")
	val image: String
)

data class ProductColorsItem(

	@field:SerializedName("color_id")
	val colorId: String,

	@field:SerializedName("color_name")
	val colorName: String,

	@field:SerializedName("color_code")
	val colorCode: String
)
