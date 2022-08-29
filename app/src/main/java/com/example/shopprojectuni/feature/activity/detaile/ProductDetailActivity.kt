package com.example.shopprojectuni.feature.activity.detaile

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.shopprojectuni.base.BaseActivity
import com.example.shopprojectuni.data.ImageItemItem
import com.example.shopprojectuni.databinding.ActivityProductDetaileBinding

class ProductDetailActivity : BaseActivity(){

    lateinit var binding: ActivityProductDetaileBinding

    //val authViewModel: AuthViewModel by viewModel()
    var productId: Int? = null
    var idColor: Int = 0
    var idSize: Int = 0
    var checkColor: Boolean = true
    var checkSize: Boolean = true
    val handler = Handler(Looper.myLooper()!!)
    var gallerySlider: List<ImageItemItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetaileBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }



}