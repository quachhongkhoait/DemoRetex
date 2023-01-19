package com.example.demoretex.data.model

import android.os.Parcelable
import com.example.demoretex.shared.DateTimeUtils
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class Movie(
    @Expose @SerializedName("author") val author: String?,
    @Expose @SerializedName("datetime") val datetime: Date?,
    @Expose @SerializedName("title") val title: String?,
    @Expose @SerializedName("description") val description: String?,
) : Parcelable {
    fun getDateTimeFormatted(): String {
        return DateTimeUtils.convertDateToString(datetime)
    }
}