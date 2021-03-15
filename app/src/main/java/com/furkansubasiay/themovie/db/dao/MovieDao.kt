package com.furkansubasiay.themovie.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.furkansubasiay.themovie.db.entity.MovieCacheEntity

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieCacheEntity: MovieCacheEntity):Long

    @Query(value = "SELECT * FROM movies ORDER BY page ASC")
    suspend fun get():List<MovieCacheEntity>

    @Query(value = "SELECT * FROM movies WHERE page==:pageNumber ORDER BY page ASC")
    suspend fun get(pageNumber:Int):List<MovieCacheEntity>
}