package com.example.demoretex.data.source.remote

import com.example.demoretex.data.model.BaseResponse
import com.example.demoretex.data.model.Movie
import retrofit2.http.GET

interface APIService {

    @GET(".")
    suspend fun getMovies(): BaseResponse<MutableList<Movie>>
}
