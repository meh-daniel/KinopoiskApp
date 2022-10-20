package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI

sealed interface MenuState {
    object Idle: MenuState
    object Loading: MenuState
    data class LoadedToolBar(
        val genres: List<MenuUI.Genre>,
        val promotion: List<MenuUI.Promotion>
    ): MenuState
    data class LoadedMovie(
        val movie: List<MenuUI.Menu>
    ): MenuState
    data class Error(val error: String, val isNoConnectionError: Boolean): MenuState
}