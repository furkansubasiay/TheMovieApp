package com.furkansubasiay.themovie.util

import java.lang.Exception

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */

sealed class DataState<out R>{
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val message: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}