package com.mobiledev.popularmovies.ui.toprated

import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.base.MvpPresenter

/**
 * Created by manu on 2/28/2018.
 */


@PerActivity
interface TopRatedPresenter<V : TopRatedView> : MvpPresenter<V> {

    fun fetchAllTopRatedrMovies(page : Int)
}