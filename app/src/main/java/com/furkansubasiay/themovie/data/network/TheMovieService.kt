package com.furkansubasiay.themovie.data.network

import com.furkansubasiay.themovie.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by FURKAN SUBAŞIAY on 11.03.2021.
 */
interface TheMovieService {

    @GET("movie/popular")
  suspend fun getMovies(@Query("page") page: Int): Response<MovieResponse>
}