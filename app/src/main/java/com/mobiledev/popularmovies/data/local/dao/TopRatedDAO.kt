package com.mobiledev.popularmovies.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mobiledev.popularmovies.data.model.TopRatedResponseModel
import io.reactivex.Flowable

/**
 * Created by manu on 3/4/2018.
 */

@Dao
interface TopRatedDAO {

    /****
     * Select query for getting top rated movies
     */
    @get:Query("SELECT * from TopRatedEntity")
    val topRatedMovies: Flowable<List<TopRatedResponseModel.TopRatedEntity>>

    /***
     * insert query for putting movies in to table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRatedMovies(resultEntities: List<TopRatedResponseModel.TopRatedEntity>)


}