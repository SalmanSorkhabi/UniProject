package com.example.shopprojectuni.feature.home.repo

import com.example.shopprojectuni.data.*
import com.example.shopprojectuni.feature.home.source.HomeDataSource
import io.reactivex.Single

class HomeRepositoryImpl(private val remoteHomeDataSource: HomeDataSource):HomeRepository {
    override fun getBanner(): Single<List<ResponseBanner>> = remoteHomeDataSource.getBanner()

    override fun getCategory(): Single<List<ResponseGeneralCat>> = remoteHomeDataSource.getCategory()

    override fun getProductAmazing(): Single<List<ResponseProductAmazing>> = remoteHomeDataSource.getProductAmazing()

    override fun getPopularProduct(): Single<List<ResponsePopularProduct>> = remoteHomeDataSource.getPopularProduct()

    override fun getBannerType(): Single<List<ResponseBannerType>> = remoteHomeDataSource.getBannerType()
}