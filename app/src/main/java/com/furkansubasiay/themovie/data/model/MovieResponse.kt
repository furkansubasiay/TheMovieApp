package com.furkansubasiay.themovie.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */

data class MovieResponse(
    @SerializedName("page") @Expose val page: Int,
    @SerializedName("results") @Expose val movieNetworkEntities: List<MovieNetworkEntity>? = null,
    @SerializedName("total_pages") @Expose val totalPages: Int,
    @SerializedName("total_results") @Expose val totalResults: Int
)