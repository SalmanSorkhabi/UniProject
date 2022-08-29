package com.example.shopprojectuni.feature.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.shopprojectuni.base.BaseFragment
import com.example.shopprojectuni.data.ResponseBanner
import com.example.shopprojectuni.databinding.FragmentHomeBinding
import com.example.shopprojectuni.feature.activity.detaile.ProductDetailActivity
import com.example.shopprojectuni.feature.home.ViewModel.HomeViewModel
import com.example.shopprojectuni.feature.home.adapter.AdapterAmazing
import com.example.shopprojectuni.feature.home.adapter.BannersAdapter
import com.example.shopprojectuni.feature.home.adapter.CategoryAdapter
import com.example.shopprojectuni.feature.home.adapter.PopularProductAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import timber.log.Timber

class HomeFragment : BaseFragment(),AdapterAmazing.OnClickItemListener {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HomeViewModel by viewModel()
    val handler = Handler(Looper.myLooper()!!)
    var bannerSlider : List<ResponseBanner>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.progressBarLiveData.observe(viewLifecycleOwner){
            setProgressBar(it)
        }

        viewModel.bannersLiveData.observe(viewLifecycleOwner){ banner ->
           // Timber.i("banner -> $it")
            bannerSlider = banner
            val bannerAdapter : BannersAdapter by inject { parametersOf(banner) }
            binding.bannersViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            binding.bannersViewPager.clipToPadding = false
            binding.bannersViewPager.clipChildren = false
            binding.bannersViewPager.offscreenPageLimit = 3
            binding.bannersViewPager.getChildAt(0)!!.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val transformer = CompositePageTransformer()
            transformer.addTransformer(MarginPageTransformer(20))
            transformer.addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.1f
            }
            binding.bannersViewPager.setPageTransformer(transformer)
            binding.bannersViewPager.adapter = bannerAdapter
            binding.dotsIndicator.setViewPager2(binding.bannersViewPager)

            binding.bannersViewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    handler.removeCallbacks(sliderRunnable)
                    handler.postDelayed(sliderRunnable,5000)
                }
            })
        }

        viewModel.generalCatLiveData.observe(viewLifecycleOwner){
            Timber.i("category -> $it")
            val categoryAdapter : CategoryAdapter by inject { parametersOf(it) }
            binding.categoryRv.apply {
                layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
                adapter = categoryAdapter
            }
        }

        viewModel.productAmazingLiveData.observe(viewLifecycleOwner){
            Timber.i("amazing -> $it")
            val amazingAdapter : AdapterAmazing by inject { parametersOf(it) }
            binding.productAmazingRv.apply {
                layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
                adapter = amazingAdapter
            }
        }

        viewModel.popularProductLiveData.observe(viewLifecycleOwner){
            Timber.i("popular -> $it ")
            val popularProductAdapter : PopularProductAdapter by inject { parametersOf(it) }
            binding.popularProductRv.apply {
                layoutManager = GridLayoutManager(context,3)
                adapter = popularProductAdapter
            }
        }

        viewModel.bannerTypeLiveData.observe(viewLifecycleOwner){
            Timber.i("bannerType --> $it")
        }
    }

    private val sliderRunnable = Runnable {
        val index: Int = binding.bannersViewPager.currentItem + 1
        binding.bannersViewPager.currentItem = index
        if (index > bannerSlider!!.size - 1) {
            binding.bannersViewPager.currentItem = 0
        }
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(sliderRunnable, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickItemAmazing(id: Int) {
        startActivity(Intent(context,ProductDetailActivity::class.java))
    }

}