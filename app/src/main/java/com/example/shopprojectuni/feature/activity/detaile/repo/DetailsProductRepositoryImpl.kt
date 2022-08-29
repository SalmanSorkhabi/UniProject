package com.example.shopprojectuni.feature.activity.detaile.repo

import com.example.shopprojectuni.data.ResponseDetailsProduct
import com.example.shopprojectuni.feature.activity.detaile.source.DetailsProductDataSource
import io.reactivex.Single

class DetailsProductRepositoryImpl(private val remoteDetailsProductDataSource: DetailsProductDataSource):DetailsProductRepository {
    override fun getDetailsProduct(productId: Int): Single<ResponseDetailsProduct> = remoteDetailsProductDataSource.getDetailsProduct(productId)
}