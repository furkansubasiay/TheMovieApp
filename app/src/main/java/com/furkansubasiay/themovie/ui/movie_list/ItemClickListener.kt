package com.furkansubasiay.themovie.ui.movie_list

import com.furkansubasiay.themovie.domain.model.Movie

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
interface ItemClickListener {
    fun onItemClicked(movie:Movie)
}