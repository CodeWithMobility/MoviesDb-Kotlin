package com.mobiledev.popularmovies.ui.base

import android.support.annotation.StringRes

/**
 * Created by manu on 2/27/2018.
 */

interface MvpView {

    val isNetworkConnected: Boolean

    fun showLoading()

    fun hideLoading()

    fun onError(@StringRes resId: Int)

    fun onError(message: String)

    fun showMessage(message: String)

    fun showMessage(@StringRes resId: Int)

    fun hideKeyboard()

}