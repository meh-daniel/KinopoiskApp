package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import meh.daniel.com.kinopoiskapp.core.BaseFragment
import meh.daniel.com.kinopoiskapp.core.observeInLifecycle
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI
import meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters.GenreAdapter
import meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters.MovieAdapter
import meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters.PromotionAdapter
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.FragmentMenuBinding

@AndroidEntryPoint
class MenuFragment: BaseFragment<MenuViewModel, FragmentMenuBinding>(R.layout.fragment_menu) {

    override val viewModel: MenuViewModel by viewModels()

    private val adapterMovies = MovieAdapter()
    private val adapterGenres = GenreAdapter(onClickGenre = { viewModel.loadMovieByGenre(it) })
    private val adapterPromotion = PromotionAdapter()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false)

    override fun initialize() {
        initMoviesRV()
        initPromotionRV()
        initGenresRV()
    }

    override fun setupSubscribers() {
        setupSubscriber()
    }

    private fun setupSubscriber() {
        viewModel.state.onEach { state: MenuState ->
            if(state is MenuState.Loaded) {
                adapterGenres.submitList(state.genres)
                adapterMovies.submitList(state.movie)
                adapterPromotion.submitList(mutableListOf<MenuUI.Promotion>(
                    MenuUI.Promotion,
                    MenuUI.Promotion,
                    MenuUI.Promotion,
                ))
            }
        }.observeInLifecycle(this)
    }

    private fun initPromotionRV() {
        with(binding) {
            promotionRV.adapter = adapterPromotion
            promotionRV.layoutManager =
                LinearLayoutManager(
                    this@MenuFragment.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }

    private fun initGenresRV() {
        with(binding) {
            genresRV.adapter = adapterGenres
            genresRV.layoutManager =
                LinearLayoutManager(
                    this@MenuFragment.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }

    private fun initMoviesRV() {
        with(binding) {
            moviesRV.adapter = adapterMovies
            moviesRV.layoutManager =
                LinearLayoutManager(
                    this@MenuFragment.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

}