package com.example.demoretex.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(@Expose @SerializedName("data") val data: T)