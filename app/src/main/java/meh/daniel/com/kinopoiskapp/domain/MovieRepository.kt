package meh.daniel.com.kinopoiskapp.domain

import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

interface MovieRepository {
    suspend fun getBy(genre: Genre): List<Movie>
    suspend fun getGenre(): List<Genre>
}