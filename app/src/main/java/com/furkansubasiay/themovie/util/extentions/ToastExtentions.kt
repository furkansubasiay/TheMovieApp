package com.furkansubasiay.themovie.util.extentions

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */

fun AppCompatActivity.showToast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}