package com.example.shopprojectuni.app

import android.app.Application
import com.example.novinshop.feature.activity.details.DetailsProductViewModel
import com.example.novinshop.feature.activity.details.adapter.*
import com.example.novinshop.feature.activity.details.repo.DetailsProductRepository
import com.example.novinshop.feature.activity.details.repo.DetailsProductRepositoryImpl
import com.example.novinshop.feature.activity.details.source.RemoteDetailsProductDataSource
import com.example.novinshop.services.ImageLoadingServices
import com.example.shopprojectuni.Utils.services.ImageLoadingImpl
import com.example.shopprojectuni.api.ApiService
import com.example.shopprojectuni.api.retrofitApi
import com.example.shopprojectuni.data.*
import com.example.shopprojectuni.feature.home.adapter.BannersAdapter
import com.example.shopprojectuni.feature.home.ViewModel.HomeViewModel
import com.example.shopprojectuni.feature.home.adapter.AdapterAmazing
import com.example.shopprojectuni.feature.home.adapter.CategoryAdapter
import com.example.shopprojectuni.feature.home.adapter.PopularProductAdapter
import com.example.shopprojectuni.feature.home.repo.HomeRepository
import com.example.shopprojectuni.feature.home.repo.HomeRepositoryImpl
import com.example.shopprojectuni.feature.home.source.RemoteHomeDataSource
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Fresco.initialize(this)


        val myModules = module {
            //Service
            single<ApiService> { retrofitApi() }
            single<ImageLoadingServices> { ImageLoadingImpl() }

            //Repository
            factory<HomeRepository> { HomeRepositoryImpl(RemoteHomeDataSource(get())) }
            factory<DetailsProductRepository> {
                DetailsProductRepositoryImpl(
                    RemoteDetailsProductDataSource(get())
                )
            }

            //Adapter
            factory { (banner: List<ResponseBanner>) -> BannersAdapter(get(), banner) }
            factory { (cat: List<ResponseGeneralCat>) -> CategoryAdapter(get(), cat) }
            factory { (amazing: List<ResponseProductAmazing>) -> AdapterAmazing(amazing, get()) }
            factory { (popular: List<ResponsePopularProduct>) ->
                PopularProductAdapter(
                    popular,
                    get()
                )
            }
            factory { (gallery: List<ImageItemItem>) -> AdapterImageGallery(get(), gallery) }
            factory { (color: List<ProductColorsItem>) -> AdapterColor(color) }
            factory { (size: List<ProductSizeItem>) -> AdapterSize(size) }
            factory { (comment: List<CommentsItem>) -> AdapterComment(comment) }
            factory { (similar: List<SimilarItem>) -> AdapterSimilar(get(), similar) }
            factory { (properties: List<PropertiesItem>) -> AdapterProperties(properties) }

            //View Model
            viewModel { HomeViewModel(get()) }
            viewModel { (id: Int) -> DetailsProductViewModel(id, get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }
    }

}