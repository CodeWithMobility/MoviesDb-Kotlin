package com.mobiledev.popularmovies.ui.popular

import com.mobiledev.popularmovies.data.model.MoviestResponseModel
import com.mobiledev.popularmovies.ui.base.MvpView

/**
 * Created by manu on 2/27/2018.
 */

interface PopularView : MvpView {

    fun onGettingPopularMovieList(moviestResponseModel: MoviestResponseModel)
}
