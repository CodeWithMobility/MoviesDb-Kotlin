package com.mobiledev.popularmovies.ui.landing

import com.mobiledev.popularmovies.data.DataManager
import com.mobiledev.popularmovies.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by manu on 2/27/2018.
 */


class LandingPresenterImpl<V : LandingView> @Inject
constructor(controller: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<V>(controller, compositeDisposable), LandingPresenter<V> {

    override fun fetchAllPopularMovies() {

    }
}