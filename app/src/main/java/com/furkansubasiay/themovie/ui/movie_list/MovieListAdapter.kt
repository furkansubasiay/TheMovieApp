package com.furkansubasiay.themovie.ui.movie_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.furkansubasiay.themovie.R
import com.furkansubasiay.themovie.BR
import com.furkansubasiay.themovie.domain.model.Movie

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */
class MovieListAdapter(private val listener: ItemClickListener) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    private val movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_container_movie, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setFadeAnimation(holder.itemView)
        val data = movieList[position]
        holder.bindData(data)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(data)
        }
    }

    override fun getItemCount(): Int = movieList.size

    fun setData(data: List<Movie>) {
        movieList.addAll(data)
        notifyDataSetChanged()
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 200
        view.startAnimation(anim)
    }


    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Movie) {
            binding.setVariable(BR.data, data)
            binding.executePendingBindings()
        }
    }
}