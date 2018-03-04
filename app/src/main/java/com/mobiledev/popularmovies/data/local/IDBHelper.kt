package com.mobiledev.popularmovies.data.local

import com.mobiledev.popularmovies.data.model.*
import io.reactivex.Observable


/**
 * Created by manu on 3/4/2018.
 */

interface IDBHelper {

    fun getPopularMovies(page: Int): Observable<PopularResponseModel>

    fun getTopRatedMovies(page: Int): Observable<TopRatedResponseModel>

    fun getUpComingMovies(page: Int): Observable<UpComingResponseModel>

    fun getNowPlayingMovies(page: Int): Observable<NowPlayingResponseModel>



    fun insertPopularMovies(resultEntities: List<PopularResponseModel.PopularEntity>)

    fun insertTopRatedMovies(resultEntities: List<TopRatedResponseModel.TopRatedEntity>)

    fun insertUpComingMovies(resultEntities: List<UpComingResponseModel.UpComingEntity>)

    fun insertNowPlayingMovies(resultEntities: List<NowPlayingResponseModel.NowPlayingEntity>)
}