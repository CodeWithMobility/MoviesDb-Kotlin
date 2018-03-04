package com.mobiledev.popularmovies.data

/**
 * Created by manu on 2/27/2018.
 */

import android.content.Context
import com.mobiledev.popularmovies.data.local.IDBHelper
import com.mobiledev.popularmovies.data.model.NowPlayingResponseModel
import com.mobiledev.popularmovies.data.model.PopularResponseModel
import com.mobiledev.popularmovies.data.model.TopRatedResponseModel
import com.mobiledev.popularmovies.data.model.UpComingResponseModel
import com.mobiledev.popularmovies.data.network.IApiHelper
import com.mobiledev.popularmovies.di.scope.ApplicationContext
import com.mobiledev.popularmovies.utils.CommonUtils
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppDataManager @Inject
constructor(
        /**
         * Application context
         */
        @param:ApplicationContext private val mContext: Context,
        /**
         * API Helper for database calls
         */
        private val mDBHelper: IDBHelper ,
        /**
         * API Helper for network calls
         */
        private val mApiHelper: IApiHelper) : DataManager {


    override fun insertTopRatedMovies(resultEntities: List<TopRatedResponseModel.TopRatedEntity>) {
        mDBHelper.insertTopRatedMovies(resultEntities)
    }


    override fun insertUpComingMovies(resultEntities: List<UpComingResponseModel.UpComingEntity>) {
        mDBHelper.insertUpComingMovies(resultEntities)
    }


    override fun insertNowPlayingMovies(resultEntities: List<NowPlayingResponseModel.NowPlayingEntity>) {
        mDBHelper.insertNowPlayingMovies(resultEntities)
    }


    override fun insertPopularMovies(resultEntities: List<PopularResponseModel.PopularEntity>) {
        mDBHelper.insertPopularMovies(resultEntities)
    }


    override fun getPopularMovies( page: Int): Observable<PopularResponseModel> {
        return if (CommonUtils.isNetworkAvailable(mContext)) {
            this.mApiHelper.getPopularMovies(page).map({ movieModels ->
                insertPopularMovies(movieModels.results!!)
                movieModels
            })
        }
        else
            mDBHelper.getPopularMovies(page)
    }


    override fun getTopRatedMovies(page: Int): Observable<TopRatedResponseModel> {
        return if (CommonUtils.isNetworkAvailable(mContext)) {
            this.mApiHelper.getTopRatedMovies(page).map({ movieModels ->
                insertTopRatedMovies(movieModels.results!!)
                movieModels
            })
        }
        else
            mDBHelper.getTopRatedMovies(page)
    }


    override fun getUpComingMovies(page: Int): Observable<UpComingResponseModel> {
        return if (CommonUtils.isNetworkAvailable(mContext)) {
            this.mApiHelper.getUpComingMovies(page).map({ movieModels ->
                insertUpComingMovies(movieModels.results!!)
                movieModels
            })
        }
        else
            mDBHelper.getUpComingMovies(page)
    }


    override fun getNowPlayingMovies(page: Int): Observable<NowPlayingResponseModel> {
        return if (CommonUtils.isNetworkAvailable(mContext)) {
            this.mApiHelper.getNowPlayingMovies(page).map({ movieModels ->
                insertNowPlayingMovies(movieModels.results!!)
                movieModels
            })
        }
        else
            mDBHelper.getNowPlayingMovies(page)
    }
}

