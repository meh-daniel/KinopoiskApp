package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import meh.daniel.com.kinopoiskapp.core.BaseFragment
import meh.daniel.com.kinopoiskapp.core.observeInLifecycle
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.FragmentMenuBinding

@AndroidEntryPoint
class MenuFragment: BaseFragment<MenuViewModel, FragmentMenuBinding>(R.layout.fragment_menu) {

    override val viewModel: MenuViewModel by viewModels()

    private val adapter = MenuAdapter()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false)

    override fun initialize() {
        initContentFilmsRV()
    }

    override fun setupSubscribers() {
        setupSubscriber()
    }

    private fun setupSubscriber() {
        viewModel.state.onEach { state: MenuState ->
            if(state is MenuState.Loaded) adapter.submitList(state.movie)
        }.observeInLifecycle(this)
    }

    private fun initContentFilmsRV() {
        with(binding) {
            contentFilms.adapter = adapter
            contentFilms.layoutManager =
                LinearLayoutManager(
                    this@MenuFragment.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

}