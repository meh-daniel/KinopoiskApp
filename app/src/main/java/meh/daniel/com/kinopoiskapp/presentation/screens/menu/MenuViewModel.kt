package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import meh.daniel.com.kinopoiskapp.core.BaseViewModel
import meh.daniel.com.kinopoiskapp.domain.MovieRepository

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MovieRepository
): BaseViewModel()