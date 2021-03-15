package com.furkansubasiay.themovie.ui.movie_list

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.furkansubasiay.themovie.domain.model.Movie
import com.furkansubasiay.themovie.domain.usecase.MovieUseCase
import com.furkansubasiay.themovie.util.DataState
import com.furkansubasiay.themovie.util.DispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Created by FURKAN SUBAŞIAY on 11.03.2021.
 */
@ExperimentalCoroutinesApi
class MovieListViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase,private val dispatchers: DispatcherProvider,@Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Movie>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Movie>>>
        get() = _dataState


    fun fetchMovies(page:Int){
        viewModelScope.launch(dispatchers.io) {
            movieUseCase.fetchMovies(page).onEach {
                _dataState.value = it
            }.launchIn(viewModelScope)
        }
    }

}