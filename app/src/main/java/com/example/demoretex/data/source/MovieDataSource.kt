package com.example.demoretex.data.source

import com.example.demoretex.data.model.Movie

class MovieDataSource {
    interface Remote {
        suspend fun getMovies(): MutableList<Movie>
    }
}