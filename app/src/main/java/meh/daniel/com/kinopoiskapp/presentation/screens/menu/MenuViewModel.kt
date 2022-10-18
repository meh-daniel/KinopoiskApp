package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.ConnectException
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import meh.daniel.com.kinopoiskapp.core.BaseViewModel
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie
import meh.daniel.com.kinopoiskapp.presentation.model.MovieUI
import meh.daniel.com.kinopoiskapp.presentation.toUI

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MovieRepository
): BaseViewModel() {

    private val _state = MutableStateFlow<MenuState>(MenuState.Loading)
    var state = _state.asStateFlow()

    init {
        loadMovieUI()
    }

    fun loadMovieUI() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movie = repository.getBy(Genre(15, "драма"))
                val genres = repository.getGenre()
                setState(MenuState.Loaded(movie.toUI(), genres.toUI()))
            } catch (e: Throwable) {
                when (e) {
                    is ConnectException -> setState(MenuState.Error(e.message.toString(), false))
                    else -> setState(MenuState.Error(e.message.toString(), false))
                }
            }
        }
    }

    private fun setState(state: MenuState) {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = state
        }
    }


}


