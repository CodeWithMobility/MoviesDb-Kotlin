package com.mobiledev.popularmovies.ui.upcoming

import com.mobiledev.popularmovies.data.model.UpComingResponseModel
import com.mobiledev.popularmovies.ui.base.MvpView

/**
 * Created by manu on 2/28/2018.
 */


interface UpComingView : MvpView {

    fun onGettingTopRatedMovieList(moviestResponseModel: UpComingResponseModel)
}
