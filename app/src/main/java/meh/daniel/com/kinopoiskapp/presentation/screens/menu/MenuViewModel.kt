package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.ConnectException
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import meh.daniel.com.kinopoiskapp.core.BaseViewModel
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI
import meh.daniel.com.kinopoiskapp.presentation.toUI

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MovieRepository
): BaseViewModel() {

    private val _state = MutableStateFlow<MenuState>(MenuState.Idle)
    var state = _state.asStateFlow()

    private val _action: Channel<MenuAction> = Channel(Channel.BUFFERED)
    var actionFlow = _action.receiveAsFlow()

    init {
        loadGenre()
        loadMovieByGenre(1)
    }

    fun loadMovieByGenre(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            setState(MenuState.Loading)
            try {
                setState(MenuState.LoadedMovie(repository.getMovieBy(id).toUI()))
            } catch (e: Throwable) {
                when (e) {
                    is ConnectException -> setState(MenuState.Error(e.message.toString(), false))
                    else -> setState(MenuState.Error(e.message.toString(), false))
                }
            }
        }
    }

    private fun loadGenre() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if(_state.value is MenuState.Idle){
                    setState(MenuState.LoadedToolBar(repository.getGenres().toUI(), mutableListOf(
                        MenuUI.Promotion,
                        MenuUI.Promotion,
                        MenuUI.Promotion,
                    )))
                }
            } catch (e: Throwable) {
                when (e) {
                    is ConnectException -> setState(MenuState.Error(e.message.toString(), false))
                    else -> setState(MenuState.Error(e.message.toString(), false))
                }
            }
        }
    }


    fun startQrScan() {
        sendAction(MenuAction.ScanQRCode)
    }

    private fun setState(state: MenuState) {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = state
        }
    }

    private fun sendAction(action: MenuAction){
        viewModelScope.launch(Dispatchers.Main){
            _action.send(action)
        }
    }


}


