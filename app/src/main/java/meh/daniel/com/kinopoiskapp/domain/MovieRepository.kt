package meh.daniel.com.kinopoiskapp.domain

import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieBy(id: Int): List<Movie>
    suspend fun getGenres(): List<Genre>
}