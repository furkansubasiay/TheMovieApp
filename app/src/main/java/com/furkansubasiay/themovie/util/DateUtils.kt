package com.furkansubasiay.themovie.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by FURKAN SUBAŞIAY on 13.03.2021.
 */

object DateUtils{

    fun getConvertedDateFromString(dateStr: String): String {
        var formatter = SimpleDateFormat("yyy-MM-dd")
        val date: Date
        try {
            date = formatter.parse(dateStr)
        } catch (ex: ParseException) {
            return ""
        }
        formatter = SimpleDateFormat("yyyy")
        return formatter.format(date)
    }
}