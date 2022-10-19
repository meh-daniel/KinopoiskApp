package meh.daniel.com.kinopoiskapp.presentation.screens.select

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import meh.daniel.com.kinopoiskapp.core.BaseViewModel
import meh.daniel.com.kinopoiskapp.domain.MovieRepository

@HiltViewModel
class SelectViewModel @Inject constructor(
    private val repository: MovieRepository
): BaseViewModel() {



}