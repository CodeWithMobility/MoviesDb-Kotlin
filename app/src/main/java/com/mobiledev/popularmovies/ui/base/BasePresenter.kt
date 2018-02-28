package com.mobiledev.popularmovies.ui.base

import com.mobiledev.popularmovies.data.DataManager

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by manu on 2/27/2018.
 */

open class BasePresenter<V : MvpView> @Inject
constructor(val dataManager: DataManager, val compositeDisposable: CompositeDisposable) : MvpPresenter<V> {

    var mvpView: V? = null
        private set

    val isViewAttached: Boolean
        get() = mvpView != null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {

        mvpView = null
    }

    override fun handleApiError(error: String) {
        mvpView!!.onError("Error")
    }

    companion object {

        private val TAG = "BasePresenter"
    }


}