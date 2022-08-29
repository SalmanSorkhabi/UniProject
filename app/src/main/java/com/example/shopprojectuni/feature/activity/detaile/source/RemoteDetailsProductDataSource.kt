package com.example.shopprojectuni.feature.activity.detaile.source

import com.example.shopprojectuni.api.ApiService
import com.example.shopprojectuni.data.ResponseDetailsProduct
import io.reactivex.Single

class RemoteDetailsProductDataSource(private val apiService: ApiService):DetailsProductDataSource {
    override fun getDetailsProduct(productId: Int): Single<ResponseDetailsProduct> = apiService.getDetailsProduct(productId)
}