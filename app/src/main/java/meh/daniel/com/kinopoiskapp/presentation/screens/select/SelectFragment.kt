package meh.daniel.com.kinopoiskapp.presentation.screens.select

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import meh.daniel.com.kinopoiskapp.core.BaseFragment
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.FragmentSelectBinding

@AndroidEntryPoint
class SelectFragment: BaseFragment<SelectViewModel, FragmentSelectBinding>(R.layout.fragment_select) {

    override val viewModel: SelectViewModel by viewModels()

    private val countryAdapter = CountryAdapter()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSelectBinding = FragmentSelectBinding.inflate(inflater, container, false)

    override fun initialize() {
        initCountryRV()
    }



    private fun initCountryRV() {
        with(binding) {
            countryRV.adapter = countryAdapter
            countryRV.layoutManager =
                LinearLayoutManager(
                    this@SelectFragment.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }

}