package com.mobiledev.popularmovies.data.network

import com.mobiledev.popularmovies.data.model.MoviestResponseModel

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by manu on 2/27/2018.
 */

@Singleton
class AppApiHelper @Inject
constructor(ref: Retrofit) : IApiHelper {


    private val mApiService: ApiService

    init {
        mApiService = ref.create(ApiService::class.java)
    }


    override fun getPopularMovies(productType: String, page: Int): Observable<MoviestResponseModel> {
        return mApiService.getPopularMovies(productType, page)
    }

    override fun getTopRatedMovies(productType: String, page: Int): Observable<MoviestResponseModel> {
        return mApiService.getTopRatedMovies(productType, page)
    }

    override fun getUpComingMovies(productType: String, page: Int): Observable<MoviestResponseModel> {
        return mApiService.getUpComingMovies(productType, page)
    }

    override fun getNowPlayingMovies(productType: String, page: Int): Observable<MoviestResponseModel> {
        return mApiService.getNowPlayingMovies(productType, page)
    }



}