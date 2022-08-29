package com.example.shopprojectuni.api

import com.example.shopprojectuni.data.*
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("home/banners.php")
    fun getBanner():Single<List<ResponseBanner>>

    @GET("home/general_cat.php")
    fun getCategory():Single<List<ResponseGeneralCat>>

    @GET("home/amazing.php")
    fun getAmazingProduct():Single<List<ResponseProductAmazing>>

    @GET("home/Popular_products.php")
    fun getPopularProduct():Single<List<ResponsePopularProduct>>

    @GET("home/banners_part2.php")
    fun getBannerType():Single<List<ResponseBannerType>>

    @GET("products/product.php")
    fun getDetailsProduct(@Query("id") productId: Int): Single<ResponseDetailsProduct>


}

fun retrofitApi():ApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://digishop.novindevelopers.ir/api/v1/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}