package com.furkansubasiay.themovie.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.furkansubasiay.themovie.db.dao.MovieDao
import com.furkansubasiay.themovie.db.entity.MovieCacheEntity

/**
 * Created by FURKAN SUBAŞIAY on 11.03.2021.
 */

@Database(entities = [MovieCacheEntity::class],version = 1,exportSchema = false)
abstract class TheMovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object{
        val DATABASE_NAME :String = "the_movie_db"
    }
}