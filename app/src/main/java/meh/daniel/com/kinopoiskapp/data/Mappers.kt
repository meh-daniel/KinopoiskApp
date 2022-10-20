package meh.daniel.com.kinopoiskapp.data

import meh.daniel.com.kinopoiskapp.data.network.model.GenreNW
import meh.daniel.com.kinopoiskapp.data.network.model.MovieNW
import meh.daniel.com.kinopoiskapp.data.storage.model.GenreSW
import meh.daniel.com.kinopoiskapp.data.storage.model.MovieSW
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

internal fun GenreNW.toDomain(): List<Genre> {
    return genres.map {
        Genre(
            id = it.id,
            name = it.genre,
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

internal fun GenreNW.toSW(): List<GenreSW> {
    return genres.map {
        GenreSW(
            id = it.id.toLong(),
            name = it.genre,
        )
    }
}

internal fun List<GenreSW>.toDomain(): List<Genre> {
    return map {
        Genre(
            id = it.id.toInt(),
            name = it.name,
        )
    }
}

@JvmName("toDomainMovieSW")
internal fun List<MovieSW>.toDomain(): List<Movie> {
    return map {
        Movie(
            name = it.name,
            poster = it.poster,
        )
    }
}

internal fun MovieNW.toSW(): List<MovieSW> {
    return items.map {
        MovieSW(
            name = it.nameRu,
            poster = it.posterUrlPreview
        )
    }
}
