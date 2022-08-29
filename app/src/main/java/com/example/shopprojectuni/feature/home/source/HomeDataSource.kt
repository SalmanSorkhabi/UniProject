package com.example.shopprojectuni.feature.home.source

import com.example.shopprojectuni.data.*
import io.reactivex.Single

interface HomeDataSource {

    fun getBanner():Single<List<ResponseBanner>>

    fun getCategory():Single<List<ResponseGeneralCat>>

    fun getProductAmazing():Single<List<ResponseProductAmazing>>

    fun getPopularProduct():Single<List<ResponsePopularProduct>>

    fun getBannerType():Single<List<ResponseBannerType>>

}