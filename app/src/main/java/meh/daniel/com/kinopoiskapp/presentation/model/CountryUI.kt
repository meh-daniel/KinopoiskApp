package meh.daniel.com.kinopoiskapp.presentation.model

sealed class CountryUI {
    data class Country(
        val id: Int,
        val name: String,
    ) : CountryUI()
}