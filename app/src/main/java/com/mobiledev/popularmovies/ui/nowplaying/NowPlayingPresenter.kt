package com.mobiledev.popularmovies.ui.nowplaying

import com.mobiledev.popularmovies.di.scope.PerActivity
import com.mobiledev.popularmovies.ui.base.MvpPresenter

/**
 * Created by manu on 2/28/2018.
 */


@PerActivity
interface NowPlayingPresenter<V : NowPlayingView> : MvpPresenter<V> {

    fun fetchAllNowPlayingMovies(page: Int)
}