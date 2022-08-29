package com.example.shopprojectuni.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.novinshop.services.ImageLoadingServices
import com.example.shopprojectuni.R
import com.example.shopprojectuni.Utils.services.view.MyImageView
import com.example.shopprojectuni.data.ResponsePopularProduct

class PopularProductAdapter(
    val popular: List<ResponsePopularProduct>,
    val imageLoadingServices: ImageLoadingServices
) : RecyclerView.Adapter<PopularProductAdapter.PopularProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularProductViewHolder {
        return PopularProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product_popular,parent,false))
    }

    override fun onBindViewHolder(holder: PopularProductViewHolder, position: Int) {
        holder.bindPopular(popular[position])
    }

    override fun getItemCount(): Int = popular.size

    inner class PopularProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPopular: MyImageView = itemView.findViewById(R.id.img_popular_product)

        fun bindPopular(popular: ResponsePopularProduct) {
            imageLoadingServices.loadImage(imgPopular,popular.image)
        }
    }

}