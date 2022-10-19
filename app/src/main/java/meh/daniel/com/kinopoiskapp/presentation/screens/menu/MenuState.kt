package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI

sealed interface MenuState {
    object Loading: MenuState
    data class Loaded(
        val movie: List<MenuUI.Menu>,
        val genres: List<MenuUI.Genre>,
    ): MenuState
    data class Error(val error: String, val isNoConnectionError: Boolean): MenuState
}