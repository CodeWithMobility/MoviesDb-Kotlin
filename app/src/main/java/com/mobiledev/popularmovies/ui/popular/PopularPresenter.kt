package com.mobiledev.popularmovies.ui.popular

import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.base.MvpPresenter

/**
 * Created by manu on 2/27/2018.
 */


@PerActivity
interface PopularPresenter<V : PopularView> : MvpPresenter<V> {

    fun fetchAllPopularMovies(page: Int)
}