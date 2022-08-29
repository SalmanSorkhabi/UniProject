package com.example.novinshop.services

import com.example.shopprojectuni.Utils.services.view.MyImageView

interface ImageLoadingServices {
    fun loadImage(imageView: MyImageView, imageUrl:String?)
}