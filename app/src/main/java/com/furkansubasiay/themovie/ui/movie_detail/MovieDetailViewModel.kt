package com.furkansubasiay.themovie.ui.movie_detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by FURKAN SUBAŞIAY on 14.03.2021.
 */
@ExperimentalCoroutinesApi
class MovieDetailViewModel @ViewModelInject constructor() : ViewModel() {

    private val _movieTitle = MutableLiveData<String>()
    val movieTitle: LiveData<String>
        get() = _movieTitle

    fun setMovieTitle(movieTitle: String) {
        _movieTitle.value = movieTitle
    }

}