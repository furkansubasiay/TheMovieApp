package com.furkansubasiay.themovie.di

import com.furkansubasiay.themovie.data.NetworkMapper
import com.furkansubasiay.themovie.data.repository.MovieRepository
import com.furkansubasiay.themovie.db.CacheMapper
import com.furkansubasiay.themovie.db.dao.MovieDao
import com.furkansubasiay.themovie.domain.usecase.MovieUseCase
import com.furkansubasiay.themovie.domain.usecase.MovieUseCaseIml
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
@Module
@InstallIn(ApplicationComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideUseCase(
        movieDao: MovieDao,
        repository: MovieRepository,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MovieUseCase = MovieUseCaseIml(movieDao, repository, cacheMapper, networkMapper)


}