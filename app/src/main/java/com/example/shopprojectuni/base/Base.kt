package com.example.shopprojectuni.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopprojectuni.R
import io.reactivex.disposables.CompositeDisposable
import java.lang.Exception


interface BaseView {
    val rootView: CoordinatorLayout?
    val myContext: Context?
    fun setProgressBar(progress: Boolean) {
        rootView?.let { rootView ->
            myContext?.let {
                var progressView = rootView.findViewById<View>(R.id.frame_progress)
                if (progressView == null && progress) {
                    progressView =
                        LayoutInflater.from(myContext).inflate(R.layout.progress_view, rootView, false)
                    rootView.addView(progressView)
                }
                progressView?.visibility = if (progress) View.VISIBLE else View.GONE
            }
        }
    }

   /* fun showEmptyState(layout:Int):View?{
        rootView?.let { rootView ->
            myContext?.let {
                var emptyState = rootView.findViewById<View>(R.id.lnrEmptyState)
                if (emptyState == null){
                    emptyState = LayoutInflater.from(myContext).inflate(layout,rootView,false)
                    rootView.addView(emptyState)
                }
                emptyState.visibility = View.VISIBLE
                return emptyState
            }
        }
        return null
    }*/
}

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override val rootView: CoordinatorLayout?
        //get() = window.decorView.rootView as CoordinatorLayout
    get() {
        val parent = window.decorView.findViewById<ViewGroup>(android.R.id.content)
            if (parent !is CoordinatorLayout){
                parent.children.forEach {
                    if (it is CoordinatorLayout){
                        return it
                    }
                }
                throw Exception("rootView must be Coordinator Layout")
            }else{
                return parent
            }
    }

    override val myContext: Context?
        get() = this
}

abstract class BaseFragment : Fragment(), BaseView {
    override val rootView: CoordinatorLayout?
        get() = view as CoordinatorLayout

    override val myContext: Context?
        get() = context
}

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    var progressBarLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}

