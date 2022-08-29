package com.example.shopprojectuni.feature.home.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.nikestore.common.asyncNetworkRequest
import com.example.shopprojectuni.Utils.DigiShopSingleObserver
import com.example.shopprojectuni.base.BaseViewModel
import com.example.shopprojectuni.data.*
import com.example.shopprojectuni.feature.home.repo.HomeRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class HomeViewModel(
    homeRepository: HomeRepository
) : BaseViewModel() {

    val bannersLiveData = MutableLiveData<List<ResponseBanner>>()
    val generalCatLiveData = MutableLiveData<List<ResponseGeneralCat>>()
    val productAmazingLiveData = MutableLiveData<List<ResponseProductAmazing>>()
    val popularProductLiveData = MutableLiveData<List<ResponsePopularProduct>>()
    val bannerTypeLiveData = MutableLiveData<List<ResponseBannerType>>()

    init {
        progressBarLiveData.value = true
        homeRepository.getBanner()
            .asyncNetworkRequest()
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : DigiShopSingleObserver<List<ResponseBanner>>(compositeDisposable) {
                override fun onSuccess(t: List<ResponseBanner>) {
                    bannersLiveData.value = t
                }
            })

        homeRepository.getCategory()
            .asyncNetworkRequest()
            .subscribe(object :
                DigiShopSingleObserver<List<ResponseGeneralCat>>(compositeDisposable) {
                override fun onSuccess(t: List<ResponseGeneralCat>) {
                    generalCatLiveData.value = t
                }
            })

        homeRepository.getProductAmazing()
            .asyncNetworkRequest()
            .subscribe(object :
                DigiShopSingleObserver<List<ResponseProductAmazing>>(compositeDisposable) {
                override fun onSuccess(t: List<ResponseProductAmazing>) {
                    productAmazingLiveData.value = t
                }
            })

        homeRepository.getPopularProduct()
            .asyncNetworkRequest()
            .subscribe(object :
                DigiShopSingleObserver<List<ResponsePopularProduct>>(compositeDisposable) {
                override fun onSuccess(t: List<ResponsePopularProduct>) {
                    popularProductLiveData.value = t
                }
            })

        homeRepository.getBannerType()
            .asyncNetworkRequest()
            .subscribe(object :
                DigiShopSingleObserver<List<ResponseBannerType>>(compositeDisposable) {
                override fun onSuccess(t: List<ResponseBannerType>) {
                    bannerTypeLiveData.value = t
                }
            })
    }

}