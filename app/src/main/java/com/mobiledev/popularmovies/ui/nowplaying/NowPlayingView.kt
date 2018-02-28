package com.mobiledev.popularmovies.ui.nowplaying

import com.mobiledev.popularmovies.data.model.MoviestResponseModel
import com.mobiledev.popularmovies.ui.base.MvpView

/**
 * Created by manu on 2/28/2018.
 */
interface NowPlayingView : MvpView {

    fun onGettingNowPlayingMovieList(moviestResponseModel: MoviestResponseModel)
}
