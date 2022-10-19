package meh.daniel.com.kinopoiskapp.domain

import meh.daniel.com.kinopoiskapp.domain.model.Country
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieBy(genre: Genre): List<Movie>
    suspend fun getGenres(): List<Genre>
    suspend fun getCountries(): List<Country>
    suspend fun getCountry(): Country
    suspend fun setCountry(country: Country)
}