package com.example.demoretex.data.repository

import com.example.demoretex.data.model.Movie
import com.example.demoretex.data.source.MovieDataSource

class MovieRepository(private val remote: MovieDataSource.Remote) {
    suspend fun getMovies(): MutableList<Movie> {
        return remote.getMovies()
    }
}