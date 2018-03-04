package com.mobiledev.popularmovies.data.network

import com.mobiledev.popularmovies.data.model.*

import io.reactivex.Observable

/**
 * Created by manu on 2/27/2018.
 */

interface IApiHelper {

    fun getPopularMovies(page: Int): Observable<PopularResponseModel>

    fun getTopRatedMovies(page: Int): Observable<TopRatedResponseModel>

    fun getUpComingMovies (page: Int): Observable<UpComingResponseModel>

    fun getNowPlayingMovies(page: Int): Observable<NowPlayingResponseModel>

}