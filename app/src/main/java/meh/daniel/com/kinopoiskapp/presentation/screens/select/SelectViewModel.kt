package meh.daniel.com.kinopoiskapp.presentation.screens.select

import javax.inject.Inject
import meh.daniel.com.kinopoiskapp.core.BaseViewModel
import meh.daniel.com.kinopoiskapp.domain.MovieRepository

class SelectViewModel @Inject constructor(
    private val repository: MovieRepository
): BaseViewModel() {



}