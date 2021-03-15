package com.furkansubasiay.themovie.di

import com.furkansubasiay.themovie.data.network.TheMovieService
import com.furkansubasiay.themovie.data.repository.MovieRepository
import com.furkansubasiay.themovie.data.repository.MovieRepositoryIml
import com.furkansubasiay.themovie.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        service: TheMovieService
    ): MovieRepository = MovieRepositoryIml(service)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined

    }
}