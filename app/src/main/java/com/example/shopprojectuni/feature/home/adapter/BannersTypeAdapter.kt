package com.example.shopprojectuni.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.novinshop.services.ImageLoadingServices
import com.example.shopprojectuni.R
import com.example.shopprojectuni.Utils.services.view.MyImageView
import com.example.shopprojectuni.data.ResponseBanner

class BannersTypeAdapter(val imageLoadingServices: ImageLoadingServices, val banners:List<ResponseBanner>):RecyclerView.Adapter<BannersTypeAdapter.BannerTypeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerTypeViewHolder {
        return BannerTypeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_banners,parent,false))
    }

    override fun onBindViewHolder(holder: BannerTypeViewHolder, position: Int) {
        holder.bindBanner(banners[position])
    }

    override fun getItemCount(): Int = banners.size

    inner class BannerTypeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val bannerImg : MyImageView = itemView.findViewById(R.id.img_banners_home)

        fun bindBanner(banner:ResponseBanner){
         //   Picasso.get().load(banner.image).into(bannerImg)
            imageLoadingServices.loadImage(bannerImg,banner.image)
        }
    }


}