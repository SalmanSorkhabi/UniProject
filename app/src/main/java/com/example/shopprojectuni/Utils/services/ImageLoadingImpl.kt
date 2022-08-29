package com.example.shopprojectuni.Utils.services

import com.example.novinshop.services.ImageLoadingServices
import com.example.shopprojectuni.Utils.services.view.MyImageView
import com.facebook.drawee.view.SimpleDraweeView

class ImageLoadingImpl: ImageLoadingServices {
    override fun loadImage(imageView: MyImageView, imageUrl: String?) {
        if (imageView is SimpleDraweeView){
            imageView.setImageURI(imageUrl)
        }
    }
}