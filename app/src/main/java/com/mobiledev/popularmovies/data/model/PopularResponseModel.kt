package com.mobiledev.popularmovies.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.reactivex.annotations.NonNull

/**
 * Created by manu on 3/4/2018.
 */
class PopularResponseModel {

    var page: Int = 0

    var total_results: Int = 0

    var total_pages: Int = 0

    var results: List<PopularEntity>? = null

    @Entity
    class PopularEntity {

        @NonNull
        @PrimaryKey
        var id: Int = 0

        @ColumnInfo(name = "vote_count")
        var vote_count: Int = 0

        @ColumnInfo(name = "isVideo")
        var isVideo: Boolean = false

        @ColumnInfo(name = "vote_average")
        var vote_average: Double = 0.toDouble()

        @ColumnInfo(name = "title")
        var title: String? = null

        @ColumnInfo(name = "popularity")
        var popularity: Double = 0.toDouble()

        @ColumnInfo(name = "poster_path")
        var poster_path: String? = null

        @ColumnInfo(name = "original_language")
        var original_language: String? = null

        @ColumnInfo(name = "original_title")
        var original_title: String? = null

        @ColumnInfo(name = "backdrop_path")
        var backdrop_path: String? = null

        @ColumnInfo(name = "isAdult")
        var isAdult: Boolean = false

        @ColumnInfo(name = "ColumnInfo")
        var overview: String? = null

        @ColumnInfo(name = "release_date")
        var release_date: String? = null

    }
}