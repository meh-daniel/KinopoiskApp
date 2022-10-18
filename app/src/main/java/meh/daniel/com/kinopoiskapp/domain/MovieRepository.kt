package meh.daniel.com.kinopoiskapp.domain

import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

interface MovieRepository {
    fun getBy(genre: Genre): List<Movie>
    fun getGenre(): List<Genre>
}