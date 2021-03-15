package com.furkansubasiay.themovie.util

import com.furkansubasiay.themovie.BuildConfig

/**
 * Created by FURKAN SUBAŞIAY on 14.03.2021.
 */

object Constants
{
    fun get_API_BASE_URL():String
    {
        return  BuildConfig.API_BASE_URL
    }
    fun get_API_KEY_VALUE():String
    {
        return  BuildConfig.API_KEY_VALUE
    }
}