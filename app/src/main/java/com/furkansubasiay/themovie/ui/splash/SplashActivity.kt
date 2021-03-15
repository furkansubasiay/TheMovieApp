package com.furkansubasiay.themovie.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.furkansubasiay.themovie.R
import com.furkansubasiay.themovie.ui.movie_list.MovieListActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Splash ekranının görünebilmesi için 1 saniyelik timer konuldu.
        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                openActivity()
            }
        }.start()
    }
    private fun openActivity() {
        startActivity(
            Intent(this,
            MovieListActivity::class.java)
        )
        this.finish()
    }
}