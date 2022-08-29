package com.example.shopprojectuni.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nikestore.common.implementSpringAnimationTrait
import com.example.novinshop.services.ImageLoadingServices
import com.example.shopprojectuni.R
import com.example.shopprojectuni.Utils.services.view.MyImageView
import com.example.shopprojectuni.data.ResponseBanner
import com.example.shopprojectuni.data.ResponseGeneralCat

class CategoryAdapter(val imageLoadingServices: ImageLoadingServices, val category:List<ResponseGeneralCat>):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_general_cat,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindBanner(category[position])
    }

    override fun getItemCount(): Int = category.size

    inner class CategoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val categoryImg : MyImageView = itemView.findViewById(R.id.categoryImg)
        private val categoryTxt : TextView = itemView.findViewById(R.id.categoryTxt)

        fun bindBanner(cat:ResponseGeneralCat){
         //   Picasso.get().load(banner.image).into(bannerImg)
            imageLoadingServices.loadImage(categoryImg,cat.image)
            categoryTxt.text = cat.title
            itemView.implementSpringAnimationTrait()
        }
    }


}