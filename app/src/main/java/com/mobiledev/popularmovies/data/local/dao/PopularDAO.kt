package com.mobiledev.popularmovies.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mobiledev.popularmovies.data.model.PopularResponseModel
import io.reactivex.Flowable

/**
 * Created by manu on 3/4/2018.
 */


@Dao
interface PopularDAO {

    /****
     * Select query for getting Popular Movies movies
     */
    @get:Query("SELECT * from PopularEntity ")
    val popularMovies: Flowable<List<PopularResponseModel.PopularEntity>>

    /***
     * insert query for putting popular movies in to table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovies(resultEntities: List<PopularResponseModel.PopularEntity>)


}