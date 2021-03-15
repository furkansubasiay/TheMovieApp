package com.furkansubasiay.themovie.domain.usecase

import com.furkansubasiay.themovie.data.NetworkMapper
import com.furkansubasiay.themovie.data.repository.MovieRepository
import com.furkansubasiay.themovie.db.CacheMapper
import com.furkansubasiay.themovie.db.dao.MovieDao
import com.furkansubasiay.themovie.domain.model.Movie
import com.furkansubasiay.themovie.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
class MovieUseCaseIml @Inject constructor(
    private val movieDao: MovieDao,
    private val movieRepository: MovieRepository,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) : MovieUseCase {

    override suspend fun fetchMovies(page: Int): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val response = movieRepository.getMovies(page)
            if (response.data != null) {
                val movies = networkMapper.mapFromEntityList(page,response.data.movieNetworkEntities!!)
                movies.forEach { movie ->
                    movieDao.insert(cacheMapper.mapToEntity(page,movie))
                }
            }
            val cachedMovies = movieDao.get(page)
            emit(DataState.Success(cacheMapper.mapFromEntityList(page,cachedMovies)))
        } catch (e: Exception) {
            emit(DataState.Error(e.message.toString()))
        }
    }

}