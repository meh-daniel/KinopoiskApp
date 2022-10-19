package meh.daniel.com.kinopoiskapp.data

import meh.daniel.com.kinopoiskapp.data.network.model.GenreNW
import meh.daniel.com.kinopoiskapp.data.network.model.MovieNW
import meh.daniel.com.kinopoiskapp.data.preferences.CountryPF
import meh.daniel.com.kinopoiskapp.data.storage.model.CountrySW
import meh.daniel.com.kinopoiskapp.data.storage.model.GenreSW
import meh.daniel.com.kinopoiskapp.data.storage.model.MovieSW
import meh.daniel.com.kinopoiskapp.domain.model.Country
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

@JvmName("toDomainGenreNW")
internal fun List<GenreNW.Country>.toDomain(): List<Country> {
    return map {
        Country(
            id = it.id,
            name = it.country,
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

@JvmName("toDomainCountrySW")
internal fun List<CountrySW>.toDomain(): List<Country> {
    return map {
        Country(
            id = it.id.toInt(),
            name = it.name,
        )
    }
}

internal fun List<GenreNW.Country>.toSW(): List<CountrySW> {
    return map {
        CountrySW(
            id = it.id.toLong(),
            name = it.country,
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

internal fun Country.toPF(): CountryPF {
    return CountryPF(
        id = id.toString(),
        name = name,
    )
}

internal fun CountryPF.toDomain(): Country {
    return Country(
        id = id.toInt(),
        name = name
    )
}
