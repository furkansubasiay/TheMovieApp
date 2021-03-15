package com.furkansubasiay.themovie.util

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
sealed class Resource<T>(val data: T?, val message:String?){
    class Success<T>(data: T):Resource<T>(data,null)
    class Error<T>(message: String?):Resource<T>(null,message)
}