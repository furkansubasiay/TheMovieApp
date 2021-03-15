package com.furkansubasiay.themovie.util

import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
object ImageBindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageURL: String?) {
            Glide.with(view.context)
                .load( "https://image.tmdb.org/t/p/w500/$imageURL")
                .into(view)
    }

    @JvmStatic
    @BindingAdapter("app:tint")
    fun ImageView.setImageTint(@ColorInt color: Int) {
        setColorFilter(color)
    }
}