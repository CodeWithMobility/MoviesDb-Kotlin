package com.mobiledev.popularmovies.ui.base

/**
 * Created by manu on 2/27/2018.
 */

interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()

    fun handleApiError(error: String)


}