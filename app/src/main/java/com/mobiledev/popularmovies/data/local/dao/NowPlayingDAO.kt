package com.mobiledev.popularmovies.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mobiledev.popularmovies.data.model.NowPlayingResponseModel
import io.reactivex.Flowable

/**
 * Created by manu on 3/4/2018.
 */

@Dao
interface NowPlayingDAO {

    /****
     * Select query for getting Now Playing movies
     */
    @get:Query("SELECT * from NowPlayingEntity")
    val nowPlayingMovies: Flowable<List<NowPlayingResponseModel.NowPlayingEntity>>

    /***
     * insert query for putting now playing movies in to table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlayingMovies(resultEntities: List<NowPlayingResponseModel.NowPlayingEntity>)


}