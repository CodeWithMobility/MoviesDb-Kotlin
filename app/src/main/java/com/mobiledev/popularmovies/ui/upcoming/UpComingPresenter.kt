package com.mobiledev.popularmovies.ui.upcoming

import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.base.MvpPresenter

/**
 * Created by manu on 2/28/2018.
 */


@PerActivity
interface UpComingPresenter<V : UpComingView> : MvpPresenter<V> {

    fun fetchAllUpCominMovies(page : Int)
}
