package com.furkansubasiay.themovie.domain.usecase

import com.furkansubasiay.themovie.domain.model.Movie
import com.furkansubasiay.themovie.util.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
interface MovieUseCase {
   suspend fun fetchMovies(page:Int): Flow<DataState<List<Movie>>>
}