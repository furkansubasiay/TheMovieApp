package com.furkansubasiay.themovie.domain.model

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */

data class Movie(
    val id:Int,
    val title:String,
    val releaseDate:String,
    val posterPath:String,
    val voteAverage:Double,
    val page:Int
)