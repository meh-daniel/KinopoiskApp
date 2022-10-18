package meh.daniel.com.kinopoiskapp.data

import meh.daniel.com.kinopoiskapp.data.network.model.GenreNW
import meh.daniel.com.kinopoiskapp.data.network.model.MovieNW
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

internal fun GenreNW.toDomain(): List<Genre> {
    return genres.map {
        Genre(
            id = it.id,
            genre = it.genre,
        )
    }
}

internal fun MovieNW.toDomain(): List<Movie> {
    return items.map {
        Movie(
            name = it.nameRu,
            poster = it.posterUrlPreview,
        )
    }
}