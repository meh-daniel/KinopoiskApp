package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import meh.daniel.com.kinopoiskapp.core.BaseFragment
import meh.daniel.com.kinopoiskapp.core.observeInLifecycle
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI
import meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters.MovieAdapter
import meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters.PromotionAdapter
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.FragmentMenuBinding

@AndroidEntryPoint
class MenuFragment: BaseFragment<MenuViewModel, FragmentMenuBinding>(R.layout.fragment_menu) {

    override val viewModel: MenuViewModel by viewModels()

    private val adapterMovies = MovieAdapter()
    private val adapterPromotion = PromotionAdapter()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false)

    override fun initialize() {
        initMoviesRV()
        initPromotionRV()
    }

    override fun setupSubscribers() {
        setupState()
        setupAction()
    }

    override fun setupListeners() {
        setupQrCodeListener()
    }

    private fun setupState() {
        viewModel.state.onEach { state: MenuState ->
            with(binding){

                progressBar.visibility = when(state) {
                    is MenuState.Loading -> View.VISIBLE
                    is MenuState.Idle -> View.VISIBLE
                    else -> View.GONE
                }

                if(state is MenuState.LoadedToolBar) {
                    appBarLayout1.visibility = View.VISIBLE
                    appBarLayout2.visibility = View.VISIBLE
                    adapterPromotion.submitList(state.promotion)
                    initGenresList(state.genres)
                }

                moviesRV.visibility = if(state is MenuState.LoadedMovie) View.VISIBLE else View.GONE

                if(state is MenuState.LoadedMovie) {
                    adapterMovies.submitList(state.movie)
                } else adapterMovies.submitList(mutableListOf())

                if(state is MenuState.Error) {
                    Snackbar.make(binding.root, state.error, Snackbar.LENGTH_SHORT).show()
                }
            }
        }.observeInLifecycle(this)
    }
    private fun setupAction() {
        viewModel.actionFlow.onEach { action ->
            when(action) {
                is MenuAction.ScanQRCode -> {
                    Snackbar.make(binding.root, "You Scanned: заглушка", Snackbar.LENGTH_SHORT).show()
                }
                is MenuAction.SelectedCountry -> {
                    Snackbar.make(binding.root, "You Select City: заглушка", Snackbar.LENGTH_SHORT).show()
                }
            }
        }.observeInLifecycle(viewLifecycleOwner)
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

    private fun initGenresList(genres: List<MenuUI.Genre>) {
        for (i in genres) {
            val chipGenre = Chip(context)
            chipGenre.id = i.id
            chipGenre.tag = i.onClick
            chipGenre.text = i.genre
            chipGenre.setTextColor(Color.parseColor("#C3C4C9"))
            chipGenre.background.setTint(Color.parseColor("#2BBEBEBE"))
            chipGenre.setChipDrawable(ChipDrawable.createFromAttributes(
                chipGenre.context,
                null,
                0,
                R.style.chips_theme
            ))
            binding.genresChipGroup.addView(chipGenre)
        }
        for (index in 0 until binding.genresChipGroup.childCount) {
            val chipSetOnClick: Chip = binding.genresChipGroup.getChildAt(index) as Chip
            chipSetOnClick.setOnCheckedChangeListener { view, isChecked ->
                if(isChecked) {
                    viewModel.loadMovieByGenre(view.id)
                    view.setTextColor(Color.parseColor("#FD3A69"))
                    view.background.setTint(Color.parseColor("#33FD3A69"))
                } else {
                    view.setTextColor(Color.parseColor("#C3C4C9"))
                    view.background.setTint(Color.parseColor("#2BBEBEBE"))
                }
            }
        }
    }

    private fun initMoviesRV() = with(binding) {
        moviesRV.adapter = adapterMovies
        moviesRV.layoutManager =
            LinearLayoutManager(
                this@MenuFragment.context,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

    private fun setupQrCodeListener() {
        binding.qrCodeImgBtn.setOnClickListener {
            viewModel.startQrScan()
        }
    }

}