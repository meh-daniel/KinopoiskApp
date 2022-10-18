package meh.daniel.com.kinopoiskapp.presentation

import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie
import meh.daniel.com.kinopoiskapp.presentation.model.MovieUI

@JvmName("toUIGenre")
internal fun List<Genre>.toUI(): List<MovieUI.Genre> {
    return map {
        MovieUI.Genre(
            id = it.id,
            genre = it.name,
        )
    }
}

internal fun List<Movie>.toUI(): List<MovieUI.Movie> {
    return map {
        MovieUI.Movie(
            name = it.name,
            poster = it.poster,
        )
    }
}