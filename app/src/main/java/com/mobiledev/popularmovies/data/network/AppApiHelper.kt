package com.mobiledev.popularmovies.data.network

import com.mobiledev.popularmovies.BuildConfig
import com.mobiledev.popularmovies.data.model.NowPlayingResponseModel
import com.mobiledev.popularmovies.data.model.PopularResponseModel
import com.mobiledev.popularmovies.data.model.TopRatedResponseModel
import com.mobiledev.popularmovies.data.model.UpComingResponseModel

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


    override fun getPopularMovies(page: Int): Observable<PopularResponseModel> {
        return mApiService.getPopularMovies(BuildConfig.API_KEY, page)
    }

    override fun getTopRatedMovies(page: Int): Observable<TopRatedResponseModel> {
        return mApiService.getTopRatedMovies(BuildConfig.API_KEY, page)
    }

    override fun getUpComingMovies(page: Int): Observable<UpComingResponseModel> {
        return mApiService.getUpComingMovies(BuildConfig.API_KEY, page)
    }

    override fun getNowPlayingMovies(page: Int): Observable<NowPlayingResponseModel> {
        return mApiService.getNowPlayingMovies(BuildConfig.API_KEY, page)
    }



}