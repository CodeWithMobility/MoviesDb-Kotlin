package com.mobiledev.popularmovies.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.mobiledev.popularmovies.data.local.dao.NowPlayingDAO
import com.mobiledev.popularmovies.data.local.dao.PopularDAO
import com.mobiledev.popularmovies.data.local.dao.TopRatedDAO
import com.mobiledev.popularmovies.data.local.dao.UpComingDAO
import com.mobiledev.popularmovies.data.model.NowPlayingResponseModel
import com.mobiledev.popularmovies.data.model.PopularResponseModel
import com.mobiledev.popularmovies.data.model.TopRatedResponseModel
import com.mobiledev.popularmovies.data.model.UpComingResponseModel

/**
 * Created by manu on 3/4/2018.
 */

@Database(entities = arrayOf(PopularResponseModel.PopularEntity::class,
        TopRatedResponseModel.TopRatedEntity::class,NowPlayingResponseModel.NowPlayingEntity::class,UpComingResponseModel.UpComingEntity::class ), version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun popularDAO(): PopularDAO

    abstract fun topRatedDAO(): TopRatedDAO

    abstract fun nowPlayingDAO(): NowPlayingDAO

    abstract fun upComingDAO(): UpComingDAO
}