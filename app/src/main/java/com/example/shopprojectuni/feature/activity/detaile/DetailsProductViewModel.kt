package com.example.novinshop.feature.activity.details

import androidx.lifecycle.MutableLiveData
import com.example.nikestore.common.asyncNetworkRequest
import com.example.shopprojectuni.Utils.DigiShopSingleObserver
import com.example.shopprojectuni.base.BaseViewModel
import com.example.shopprojectuni.data.ResponseDetailsProduct
import com.example.shopprojectuni.feature.activity.detaile.repo.DetailsProductRepository

class DetailsProductViewModel(
    productId: Int,
    detailsProductRepository: DetailsProductRepository
) : BaseViewModel() {

    val detailsProductLiveData = MutableLiveData<ResponseDetailsProduct>()
    val productIdLiveData = MutableLiveData<Int>()

    init {
        progressBarLiveData.value = true
        productIdLiveData.value = productId
        detailsProductRepository.getDetailsProduct(productIdLiveData.value!!)
            .asyncNetworkRequest()
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object :
                DigiShopSingleObserver<ResponseDetailsProduct>(compositeDisposable) {
                override fun onSuccess(t: ResponseDetailsProduct) {
                    detailsProductLiveData.value = t
                }
            })


    }
}