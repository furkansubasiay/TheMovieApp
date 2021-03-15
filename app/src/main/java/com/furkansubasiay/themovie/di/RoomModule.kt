package com.furkansubasiay.themovie.di

import android.content.Context
import androidx.room.Room
import com.furkansubasiay.themovie.db.TheMovieDatabase
import com.furkansubasiay.themovie.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideTheMovieDb(@ApplicationContext context: Context): TheMovieDatabase {
        return Room.databaseBuilder(
            context, TheMovieDatabase::class.java,
            TheMovieDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(movieDatabase: TheMovieDatabase):MovieDao{
        return movieDatabase.movieDao()
    }
}