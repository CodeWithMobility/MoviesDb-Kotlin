package com.mobiledev.popularmovies.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mobiledev.popularmovies.data.model.UpComingResponseModel
import io.reactivex.Flowable

/**
 * Created by manu on 3/4/2018.
 */

@Dao
interface UpComingDAO {

    /****
     * Select query for getting upcoming movies
     */
    @get:Query("SELECT * from UpComingEntity")
    val upComingMovies: Flowable<List<UpComingResponseModel.UpComingEntity>>

    /***
     * insert query for putting upcoming movies in to table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpCominMovies(resultEntities: List<UpComingResponseModel.UpComingEntity>)


}