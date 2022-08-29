package com.example.shopprojectuni.feature.home.source

import com.example.shopprojectuni.api.ApiService
import com.example.shopprojectuni.data.*
import io.reactivex.Single

class RemoteHomeDataSource(private val apiService: ApiService):HomeDataSource {
    override fun getBanner(): Single<List<ResponseBanner>> = apiService.getBanner()

    override fun getCategory(): Single<List<ResponseGeneralCat>> = apiService.getCategory()

    override fun getProductAmazing(): Single<List<ResponseProductAmazing>> = apiService.getAmazingProduct()

    override fun getPopularProduct(): Single<List<ResponsePopularProduct>> = apiService.getPopularProduct()

    override fun getBannerType(): Single<List<ResponseBannerType>> = apiService.getBannerType()
}