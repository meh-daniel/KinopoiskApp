package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import meh.daniel.com.kinopoiskapp.core.BaseFragment
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.FragmentMenuBinding

@AndroidEntryPoint
class MenuFragment: BaseFragment<MenuViewModel, FragmentMenuBinding>(R.layout.fragment_menu) {

    override val viewModel: MenuViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false)



}