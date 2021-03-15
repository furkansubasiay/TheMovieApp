package com.furkansubasiay.themovie.db

import com.furkansubasiay.themovie.domain.model.Movie
import com.furkansubasiay.themovie.db.entity.MovieCacheEntity
import com.furkansubasiay.themovie.util.DateUtils
import com.furkansubasiay.themovie.util.EntityMapper
import javax.inject.Inject

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */

class CacheMapper @Inject constructor():EntityMapper<MovieCacheEntity, Movie>{
    override fun mapFromEntity(page:Int,entity: MovieCacheEntity): Movie {
        return Movie(
            id = entity.movieId,
            title = entity.title,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            voteAverage = entity.voteAverage,
            page =page
        )
    }

    override fun mapToEntity(page:Int,domainModel: Movie): MovieCacheEntity {
        return MovieCacheEntity(
            movieId = domainModel.id,
            title = domainModel.title,
            posterPath =domainModel.posterPath,
            releaseDate =  DateUtils.getConvertedDateFromString(domainModel.releaseDate),
            voteAverage = domainModel.voteAverage,
            page = page
        )
    }

    fun mapFromEntityList(page:Int,entities: List<MovieCacheEntity>): List<Movie> {
        return entities.map { mapFromEntity(page,it) }
    }
}