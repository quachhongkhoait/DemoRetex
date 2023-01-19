package com.example.demoretex.presentation.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoretex.data.model.Movie
import com.example.demoretex.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movies = MutableLiveData<MutableList<Movie>>()
    val loading = MutableLiveData(false)
    val error = MutableLiveData<String>()

    fun getMovies() {
        loading.value = true
        viewModelScope.launch {
            try {
                movies.value = movieRepository.getMovies()
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }
}