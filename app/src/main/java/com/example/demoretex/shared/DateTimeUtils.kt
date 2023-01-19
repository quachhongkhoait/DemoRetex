package com.example.demoretex.shared

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {

    @SuppressLint("SimpleDateFormat")
    fun convertDateToString(
        date: Date?,
        outputPattern: String = FORMAT_YYYY_MM_DD_HH_MM_SS,
    ): String {
        if (date == null) return EMPTY
        val outputFormat = SimpleDateFormat(outputPattern)
        return try {
            outputFormat.format(date)
        } catch (ignored: Exception) {
            EMPTY
        }
    }

    const val FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"
}