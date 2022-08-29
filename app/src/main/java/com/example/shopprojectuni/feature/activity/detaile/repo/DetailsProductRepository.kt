package com.example.shopprojectuni.feature.activity.detaile.repo

import com.example.shopprojectuni.data.ResponseDetailsProduct
import io.reactivex.Single

interface DetailsProductRepository {

    fun getDetailsProduct(productId:Int):Single<ResponseDetailsProduct>

}