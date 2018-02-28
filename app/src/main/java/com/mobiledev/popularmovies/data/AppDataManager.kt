package com.mobiledev.popularmovies.data

/**
 * Created by manu on 2/27/2018.
 */

import android.content.Context

import com.mobiledev.popularmovies.data.model.MoviestResponseModel
import com.mobiledev.popularmovies.data.network.IApiHelper
import com.mobiledev.popularmovies.di.scope.ApplicationContext

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable


@Singleton
class AppDataManager @Inject
constructor(
        /**
         * Application context
         */
        @param:ApplicationContext private val mContext: Context,
        /**
         * API Helper for network calls
         */
        private val mApiHelper: IApiHelper) : DataManager {

    override fun getPopularMovies(apiKey: String, page: Int): Observable<MoviestResponseModel> {
        return mApiHelper.getPopularMovies(apiKey, page).map { productModel -> productModel }
    }

    override fun getTopRatedMovies(apiKey: String, page: Int): Observable<MoviestResponseModel> {
        return mApiHelper.getTopRatedMovies(apiKey, page).map { productModel -> productModel }
    }

    override fun getUpComingMovies(apiKey: String, page: Int): Observable<MoviestResponseModel> {
        return mApiHelper.getUpComingMovies(apiKey, page).map { productModel -> productModel }
    }
    override fun getNowPlayingMovies(apiKey: String, page: Int): Observable<MoviestResponseModel> {
        return mApiHelper.getNowPlayingMovies(apiKey, page).map { productModel -> productModel }
    }
}