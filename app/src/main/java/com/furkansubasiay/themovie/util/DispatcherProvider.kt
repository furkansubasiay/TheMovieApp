package com.furkansubasiay.themovie.util

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
interface DispatcherProvider {
    val main:CoroutineDispatcher
    val io:CoroutineDispatcher
    val default:CoroutineDispatcher
    val unconfined:CoroutineDispatcher
}