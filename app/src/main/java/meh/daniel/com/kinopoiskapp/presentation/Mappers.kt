package meh.daniel.com.kinopoiskapp.presentation

import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI

@JvmName("toUIGenre")
internal fun List<Genre>.toUI(): List<MenuUI.Genre> {
    return map {
        MenuUI.Genre(
            id = it.id,
            genre = it.name,
        )
    }
}

internal fun List<Movie>.toUI(): List<MenuUI.Menu> {
    return map {
        MenuUI.Menu(
            name = it.name,
            poster = it.poster,
        )
    }
}