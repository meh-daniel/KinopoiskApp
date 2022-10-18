package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import meh.daniel.com.kinopoiskapp.presentation.model.MovieUI

sealed interface MenuState {
    object Loading: MenuState
    data class Loaded(
        val movie: List<MovieUI.Movie>,
        val genres: List<MovieUI.Genre>,
    ): MenuState
    data class Error(val error: String, val isNoConnectionError: Boolean): MenuState
}