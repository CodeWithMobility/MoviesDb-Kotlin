package com.mobiledev.popularmovies.utils


import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by manu on 3/4/2018.
 */

object CommonUtils {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}// This utility class is not publicly instantiable