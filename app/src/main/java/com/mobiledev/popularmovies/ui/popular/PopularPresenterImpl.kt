package com.mobiledev.popularmovies.ui.popular

import com.mobiledev.popularmovies.BuildConfig
import com.mobiledev.popularmovies.data.DataManager
import com.mobiledev.popularmovies.data.model.MoviestResponseModel
import com.mobiledev.popularmovies.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Timed
import javax.inject.Inject


/**
 * Created by manu on 2/27/2018.
 */

class PopularPresenterImpl<V : PopularView> @Inject
constructor(controller: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<V>(controller, compositeDisposable), PopularPresenter<V> {


    override fun fetchAllPopularMovies(page:Int) {
        mvpView?.showLoading()
        compositeDisposable.add(dataManager
                .getPopularMovies(BuildConfig.API_KEY,page)
                .timeInterval()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : DisposableObserver<Timed<MoviestResponseModel>>() {
                    override fun onComplete() {}
                    override fun onError(error: Throwable) {
                        mvpView?.hideLoading()
                        mvpView?.onError("Please try again")
                    }
                    override fun onNext(productModels: Timed<MoviestResponseModel>) {
                        mvpView?.hideLoading()
                        mvpView?.onGettingPopularMovieList(productModels.value())

                    }
                }))
    }
}