package com.mobiledev.popularmovies.ui.popular

import android.net.Uri
import android.view.View
import android.widget.TextView

import com.facebook.drawee.view.SimpleDraweeView
import com.mobiledev.popularmovies.BuildConfig
import com.mobiledev.popularmovies.R
import com.mobiledev.popularmovies.data.model.MoviestResponseModel
import com.mobiledev.popularmovies.ui.base.BaseViewHolder


/**
 * Created by manu on 2/27/2018.
 */

class PopularViewHolder(var itemview: View, var onProductClickListener: PopularAdapter.OnProductClickListener?) : BaseViewHolder(itemview) {


    internal var imageView: SimpleDraweeView


    internal var titleTV: TextView

    internal var resultsEntity: MoviestResponseModel.ResultsEntity? =null

    init {
        imageView = itemview.findViewById(R.id.my_image_view)
        titleTV = itemview.findViewById(R.id.titleTV)

    }

    override fun bind(model: Any) {
        resultsEntity = model as MoviestResponseModel.ResultsEntity
        val uri = Uri.parse(BuildConfig.IMAGE_URL_SMALL + resultsEntity!!.poster_path!!)
        imageView.setImageURI(uri)
        titleTV.text = resultsEntity!!.title
    }


    fun onMovieClick() {
        if (onProductClickListener != null) {
            onProductClickListener!!.onProductClick(this!!.resultsEntity!!, itemview)
        }
    }

}