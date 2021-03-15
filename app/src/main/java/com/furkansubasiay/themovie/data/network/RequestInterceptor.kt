package com.furkansubasiay.themovie.data.network

import com.furkansubasiay.themovie.util.Constants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by FURKAN SUBAŞIAY on 11.03.2021.
 */

@Singleton
class RequestInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val httpUrl = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, Constants.get_API_KEY_VALUE())
            .build()

        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }

    companion object {
        const val API_KEY_QUERY = "api_key"
    }
}