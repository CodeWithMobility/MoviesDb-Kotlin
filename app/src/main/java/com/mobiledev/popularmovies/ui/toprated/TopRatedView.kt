package com.mobiledev.popularmovies.ui.toprated

import com.mobiledev.popularmovies.data.model.TopRatedResponseModel
import com.mobiledev.popularmovies.ui.base.MvpView

/**
 * Created by manu on 2/28/2018.
 */

interface TopRatedView : MvpView{

    fun onGettingTopRatedMovieList(moviestResponseModel: TopRatedResponseModel)
}
