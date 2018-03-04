package com.mobiledev.popularmovies.data.local

import android.arch.persistence.room.RoomDatabase
import com.mobiledev.popularmovies.data.model.*



import javax.inject.Inject

import io.reactivex.Observable

/**
 * Created by manu on 3/4/2018.
 */

class DatabaseHelper @Inject
internal constructor(database: RoomDatabase) : IDBHelper {


    private val database: LocalDatabase

    init {
        this.database = database as LocalDatabase
    }


    override fun getTopRatedMovies(page: Int): Observable<TopRatedResponseModel> {
        return Observable.fromCallable {
            val reviews = database.topRatedDAO().topRatedMovies.blockingFirst()
            val topRatedResponseModel = TopRatedResponseModel()
            topRatedResponseModel.results = reviews
            topRatedResponseModel
        }
    }

    override fun getUpComingMovies(page: Int): Observable<UpComingResponseModel> {
        return Observable.fromCallable {
            val reviews = database.upComingDAO().upComingMovies.blockingFirst()
            val upComingResponseModel = UpComingResponseModel()
            upComingResponseModel.results = reviews
            upComingResponseModel
        }
    }

    override fun getNowPlayingMovies(page: Int): Observable<NowPlayingResponseModel> {
        return Observable.fromCallable {
            val reviews = database.nowPlayingDAO().nowPlayingMovies.blockingFirst()
            val nowPlayingResponseModel = NowPlayingResponseModel()
            nowPlayingResponseModel.results = reviews
            nowPlayingResponseModel
        }
    }

    override fun getPopularMovies(page: Int): Observable<PopularResponseModel> {
        return Observable.fromCallable {
            val reviews = database.popularDAO().popularMovies.blockingFirst()
            val popularResponseModel = PopularResponseModel()
            popularResponseModel.results = reviews
            popularResponseModel
        }
    }



    override fun insertPopularMovies(resultEntities: List<PopularResponseModel.PopularEntity>) {
        database.popularDAO().insertPopularMovies(resultEntities)
    }

    override fun insertTopRatedMovies(resultEntities: List<TopRatedResponseModel.TopRatedEntity>) {
        database.topRatedDAO().insertTopRatedMovies(resultEntities)
    }

    override fun insertUpComingMovies(resultEntities: List<UpComingResponseModel.UpComingEntity>) {
        database.upComingDAO().insertUpCominMovies(resultEntities)
    }

    override fun insertNowPlayingMovies(resultEntities: List<NowPlayingResponseModel.NowPlayingEntity>) {
        database.nowPlayingDAO().insertNowPlayingMovies(resultEntities)
    }

}