package com.furkansubasiay.themovie.data

import com.furkansubasiay.themovie.data.model.MovieNetworkEntity
import com.furkansubasiay.themovie.domain.model.Movie
import com.furkansubasiay.themovie.util.EntityMapper
import javax.inject.Inject

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */
class NetworkMapper @Inject constructor() : EntityMapper<MovieNetworkEntity, Movie> {
    override fun mapFromEntity(page:Int,entity: MovieNetworkEntity): Movie {
        return Movie(
            id = entity.id,
            title = entity.title,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            voteAverage = entity.voteAverage,
            page = page
        )
    }

    override fun mapToEntity(page:Int,domainModel: Movie): MovieNetworkEntity {
        TODO("Not yet implemented")
    }


    fun mapFromEntityList(page:Int,entities: List<MovieNetworkEntity>): List<Movie> {
        return entities.map { mapFromEntity(page,it) }
    }


}