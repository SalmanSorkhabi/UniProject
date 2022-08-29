package com.example.shopprojectuni.feature.home.adapter

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nikestore.common.formatOff
import com.example.nikestore.common.formatPrice
import com.example.nikestore.common.formatSellsCount
import com.example.novinshop.services.ImageLoadingServices
import com.example.shopprojectuni.R
import com.example.shopprojectuni.Utils.services.view.MyImageView
import com.example.shopprojectuni.data.ResponseProductAmazing

const val PRODUCT_ITEM_FIRST = 1
const val PRODUCT_ITEM_AMAZING = 2

class AdapterAmazing(
    val amazingProducts: List<ResponseProductAmazing>,
    val imageLoadingServices: ImageLoadingServices
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var onClickItemListener: OnClickItemListener

    fun setOnClickAmazing(onClickItemListener: OnClickItemListener){
        this.onClickItemListener = onClickItemListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == PRODUCT_ITEM_FIRST){
            return FirstItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_first_amazing,parent,false))
        }else{
            return AmazingProductView(LayoutInflater.from(parent.context).inflate(R.layout.item_product_amazing,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == PRODUCT_ITEM_FIRST){
            (holder as FirstItemViewHolder).imgFirst.setActualImageResource(R.drawable.produt_item_image)
        }else{
            val itemAmazing = amazingProducts[position - 1]
            imageLoadingServices.loadImage((holder as AmazingProductView).imgProduct,itemAmazing.image)
            holder.txtTitle.text = itemAmazing.name
            holder.txtFree.text = formatOff(itemAmazing.offPercent)
            holder.txtOffPrice.text = formatPrice(itemAmazing.amazingPrice)
            holder.txtPrice.text = formatPrice(itemAmazing.price)
            holder.txtPrice.paintFlags = android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
            holder.prAmazing.max = itemAmazing.number
            holder.prAmazing.progress = itemAmazing.sellsCount
            holder.txtCount.text = formatSellsCount(itemAmazing.sellsCount)
            val countDownTimer: CountDownTimer = object : CountDownTimer(itemAmazing.amazingTime,1000){
                override fun onTick(p0: Long) {
                    val hour = p0 / 3600000 % 24
                    val min = p0 / 60000 % 60
                    val sec = p0 / 1000 % 60
                    holder.txtTime.text = holder.itemView.context.getString(R.string.time,hour,min,sec)
                }

                override fun onFinish() {
                    holder.txtTime.text = "تخفیف تمام شد"
                }

            }
            countDownTimer.start()

            holder.itemView.setOnClickListener {
                onClickItemListener.onClickItemAmazing(itemAmazing.id)
            }
        }
    }

    override fun getItemCount(): Int = (amazingProducts.size) + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            PRODUCT_ITEM_FIRST
        }else {
            PRODUCT_ITEM_AMAZING
        }
    }
    inner class AmazingProductView(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgProduct: MyImageView = itemView.findViewById(R.id.img_product_amazing)
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title_product_amazing)
        val txtFree: TextView = itemView.findViewById(R.id.txt_off_percent_product_amazing)
        val txtOffPrice: TextView = itemView.findViewById(R.id.txt_off_price_product_amazing)
        val txtPrice: TextView = itemView.findViewById(R.id.txt_price_product_amazing)
        val txtTime: TextView = itemView.findViewById(R.id.txt_time_product_amazing)
        val txtCount: TextView = itemView.findViewById(R.id.txt_count_sell_product_amazing)
        val prAmazing : ProgressBar = itemView.findViewById(R.id.progressBar_product_amazing)
    }

    inner class FirstItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgFirst : MyImageView = itemView.findViewById(R.id.img_first)
    }


    interface OnClickItemListener{
        fun onClickItemAmazing(id:Int)
    }

}