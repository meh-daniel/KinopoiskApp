package meh.daniel.com.kinopoiskapp.presentation.screens.select

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import meh.daniel.com.kinopoiskapp.core.BaseFragment
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.FragmentSelectBinding

class SelectFragment: BaseFragment<SelectViewModel, FragmentSelectBinding>(R.layout.fragment_select) {

    override val viewModel: SelectViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSelectBinding = FragmentSelectBinding.inflate(inflater, container, false)


}