package com.mobiledev.popularmovies.ui.landing

import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.base.MvpPresenter
/**
 * Created by manu on 2/27/2018.
 */


@PerActivity
interface LandingPresenter<V : LandingView> : MvpPresenter<V> {

    fun fetchAllPopularMovies()
}