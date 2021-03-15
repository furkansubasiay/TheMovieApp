package com.furkansubasiay.themovie.db.entity

import androidx.room.*

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */
@Entity(tableName = "movies")
data class MovieCacheEntity(
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "release_date")
    var releaseDate: String,

    @ColumnInfo(name = "poster_path")
    var posterPath: String,

    @ColumnInfo(name = "vote_average")
    var voteAverage: Double,

    @ColumnInfo(name = "page")
    var page: Int,
)