package com.mobiledev.popularmovies.ui.nowplaying

import android.view.View
import android.view.ViewGroup
import com.mobiledev.popularmovies.R
import com.mobiledev.popularmovies.data.model.MoviestResponseModel
import com.mobiledev.popularmovies.ui.base.BaseActivity
import com.mobiledev.popularmovies.ui.base.BaseAdapter
import com.mobiledev.popularmovies.ui.base.BaseViewHolder
import java.util.ArrayList

/**
 * Created by manu on 2/28/2018.
 */
class NowPlayingAdapter(activity: BaseActivity) : BaseAdapter(activity) {

    protected var productModelArrayList: ArrayList<MoviestResponseModel.ResultsEntity>? = ArrayList()
    internal var onProductClickListener: OnProductClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return NowPlayingViewHolder(inflater.inflate(R.layout.movie_row, parent, false), onProductClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(productModelArrayList!![position])
    }

    override fun getItemCount(): Int {
        return if (productModelArrayList == null || productModelArrayList!!.size == 0) 0 else productModelArrayList!!.size
    }

    fun addItems(results: List<MoviestResponseModel.ResultsEntity>?) {
        if (results == null || results.size == 0) return
        val firstPosition = if (productModelArrayList!!.size == 0) 0 else productModelArrayList!!.size - 1
        productModelArrayList!!.addAll(results)
        notifyItemRangeChanged(firstPosition, results.size)
    }

    fun setOnItemClickListener(onProductClickListener: OnProductClickListener) {
        this.onProductClickListener = onProductClickListener
    }

    interface OnProductClickListener {
        fun onProductClick(resultsEntity: MoviestResponseModel.ResultsEntity, v: View)
    }

}
