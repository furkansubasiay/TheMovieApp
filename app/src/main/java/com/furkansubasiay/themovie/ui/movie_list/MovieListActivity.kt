package com.furkansubasiay.themovie.ui.movie_list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.furkansubasiay.themovie.R
import com.furkansubasiay.themovie.databinding.ActivityMovieListBinding
import com.furkansubasiay.themovie.domain.model.Movie
import com.furkansubasiay.themovie.ui.base.BaseActivity
import com.furkansubasiay.themovie.ui.movie_detail.MOVIE_TITLE
import com.furkansubasiay.themovie.ui.movie_detail.MovieDetailActivity
import com.furkansubasiay.themovie.util.DataState
import com.furkansubasiay.themovie.util.extentions.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val TOTAL_AVAIBLE_PAGE = 5

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MovieListActivity : BaseActivity(), ItemClickListener {

    private lateinit var binding: ActivityMovieListBinding
    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var movieListAdapter: MovieListAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        initRecyclerView()
        viewModel.fetchMovies(page)
        subscribeObserver()

       binding.btnAdd.setOnClickListener {
            if (page < 5) {
                page++
                viewModel.fetchMovies(page)
            }
        }

    }

    private fun initRecyclerView() {
        movieListAdapter = MovieListAdapter(this)
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MovieListActivity)
            setHasFixedSize(true)
            adapter = movieListAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!canScrollVertically(1)) {
                        if (page < TOTAL_AVAIBLE_PAGE) {
                            page++
                            viewModel.fetchMovies(page)
                        }
                    }
                }
            })
        }
    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Movie>> -> {
                    displayProgress(false)
                    movieListAdapter.setData(dataState.data)
                }
                is DataState.Error -> {
                    displayProgress(false)
                    this.showToast(dataState.message)
                }
                is DataState.Loading -> {
                    displayProgress(true)
                }
            }
        })
    }

    private fun displayProgress(isLoading: Boolean) {
        if (page == 1) {
            binding.isLoading = isLoading
        } else {
            binding.isLoadingMore = isLoading
        }
    }

    override fun onItemClicked(movie: Movie) {
        startActivity(Intent(this, MovieDetailActivity::class.java).apply {
            putExtra(MOVIE_TITLE, movie.title)
        })
    }
}