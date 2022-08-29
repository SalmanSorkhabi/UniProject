package com.example.shopprojectuni.feature.activity.detaile.source

import com.example.shopprojectuni.data.ResponseDetailsProduct
import io.reactivex.Single

interface DetailsProductDataSource {

    fun getDetailsProduct(productId:Int):Single<ResponseDetailsProduct>

}