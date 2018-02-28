package com.mobiledev.popularmovies.data.network

import com.mobiledev.popularmovies.data.model.MoviestResponseModel

import io.reactivex.Observable

/**
 * Created by manu on 2/27/2018.
 */

interface IApiHelper {


    fun getPopularMovies(Api: String, page: Int): Observable<MoviestResponseModel>
    fun getTopRatedMovies(Api: String, page: Int): Observable<MoviestResponseModel>
    fun getUpComingMovies(Api: String, page: Int): Observable<MoviestResponseModel>
    fun getNowPlayingMovies(Api: String, page: Int): Observable<MoviestResponseModel>



}