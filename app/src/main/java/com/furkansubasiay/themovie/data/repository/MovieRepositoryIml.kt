package com.furkansubasiay.themovie.data.repository

import com.furkansubasiay.themovie.data.model.MovieResponse
import com.furkansubasiay.themovie.data.network.TheMovieService
import com.furkansubasiay.themovie.util.Resource
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */

class MovieRepositoryIml @Inject constructor(
    private val movieService: TheMovieService
) : MovieRepository {

    override suspend fun getMovies(page: Int): Resource<MovieResponse> {
        return try {
            val response = movieService.getMovies(page)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
          Resource.Error(e.message.toString())
        }
    }
}