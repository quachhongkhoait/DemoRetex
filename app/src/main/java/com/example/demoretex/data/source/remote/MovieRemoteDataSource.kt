package com.example.demoretex.data.source.remote

import com.example.demoretex.data.model.Movie
import com.example.demoretex.data.source.MovieDataSource

class MovieRemoteDataSource(private val apiService: APIService) : MovieDataSource.Remote {

    override suspend fun getMovies(): MutableList<Movie> {
        return apiService.getMovies().data
    }
}