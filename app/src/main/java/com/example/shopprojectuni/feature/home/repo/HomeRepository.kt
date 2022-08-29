package com.example.shopprojectuni.feature.home.repo

import com.example.shopprojectuni.data.*
import io.reactivex.Single

interface HomeRepository {

    fun getBanner():Single<List<ResponseBanner>>

    fun getCategory():Single<List<ResponseGeneralCat>>

    fun getProductAmazing():Single<List<ResponseProductAmazing>>

    fun getPopularProduct():Single<List<ResponsePopularProduct>>

    fun getBannerType():Single<List<ResponseBannerType>>

}