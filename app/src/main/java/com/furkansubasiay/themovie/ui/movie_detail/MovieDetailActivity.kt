package com.furkansubasiay.themovie.ui.movie_detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.furkansubasiay.themovie.R
import com.furkansubasiay.themovie.databinding.ActivityMovieDetailBinding
import com.furkansubasiay.themovie.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val MOVIE_TITLE = "movie_title"

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MovieDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        binding.viewModel = viewModel
        val title: String
        intent.apply {
            title = this.extras?.getString(MOVIE_TITLE).toString()
        }
        viewModel.setMovieTitle(title)
    }
}