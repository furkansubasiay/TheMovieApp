package com.furkansubasiay.themovie.data.repository

import com.furkansubasiay.themovie.data.model.MovieResponse
import com.furkansubasiay.themovie.util.Resource

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
interface MovieRepository {
   suspend fun getMovies(page:Int): Resource<MovieResponse>
}