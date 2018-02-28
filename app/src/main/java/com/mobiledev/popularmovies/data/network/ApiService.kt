package com.mobiledev.popularmovies.data.network

/**
 * Created by manu on 2/27/2018.
 */


import com.mobiledev.popularmovies.data.model.MoviestResponseModel

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("movie/popular?")
    fun getPopularMovies(@Query("api_key") api_key: String, @Query("page") page : Int): Observable<MoviestResponseModel>

    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") api_key: String, @Query("page") page : Int): Observable<MoviestResponseModel>

    @GET("movie/upcoming")
    fun getUpComingMovies(@Query("api_key") api_key: String, @Query("page") page : Int): Observable<MoviestResponseModel>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") api_key: String, @Query("page") page : Int): Observable<MoviestResponseModel>

}