package meh.daniel.com.kinopoiskapp.data

import android.content.Context
import meh.daniel.com.kinopoiskapp.data.network.KinopoiskApi
import meh.daniel.com.kinopoiskapp.data.preferences.CountryPF
import meh.daniel.com.kinopoiskapp.data.storage.MovieDataBase
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import meh.daniel.com.kinopoiskapp.domain.model.Country
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

private const val ORDER = ""
private const val PAGE = 1

class MovieRepositoryImpl(
    private val context: Context,
    private val api: KinopoiskApi,
    private val db: MovieDataBase,
): MovieRepository {

    private companion object {
        const val SESSION_PREFERENCES = "sessionPreferences"
        const val COUNTRY_ID = "countryId"
        const val COUNTRY_NAME = "countryName"
    }

    private val sessionPreferences by lazy {
        context.getSharedPreferences(SESSION_PREFERENCES, Context.MODE_PRIVATE)
    }

    override suspend fun getMovieBy(genre: Genre): List<Movie> {
        return try {
            val movies = api.getMovie(
                idGenre = genre.id,
                order = ORDER,
                page = PAGE
            )
            db.movieDao().updateLastMovies(movies.toSW())
            movies.toDomain()
        } catch (e: Throwable) {
            db.movieDao().getAllMovies().toDomain()
        }
    }

    override suspend fun getGenres(): List<Genre> {
        return try {
            db.movieDao().getAllGenres().toDomain()
        } catch (e: Throwable) {
            val genres = api.getGenres()
            db.movieDao().insertGenres(genres.toSW())
            genres.toDomain()
        }
    }

    override suspend fun getCountries(): List<Country> {
        return try {
            db.movieDao().getAllCountries().toDomain()
        } catch (e: Throwable) {
            val countries = api.getGenres().countries
            db.movieDao().insertCountries(countries.toSW())
            countries.toDomain()
        }
    }

    override suspend fun getCountry(): Country {
        val country = getCountrySettings()
        return if (country.name.isNullOrBlank()) {
            val countryNew = getCountries().first()
            setupCountry(countryNew.toPF())
            countryNew
        } else country.toDomain()
    }

    override suspend fun setCountry(country: Country) {
        setupCountry(country.toPF())
    }

    private fun setupCountry(country: CountryPF){
        sessionPreferences
            .edit()
            .putString(COUNTRY_ID, country.id)
            .putString(COUNTRY_NAME, country.name)
            .apply()
    }

    private fun getCountrySettings() : CountryPF {
        return CountryPF(
            id = sessionPreferences.getString(COUNTRY_ID, "").toString(),
            name = sessionPreferences.getString(COUNTRY_NAME, "").toString(),
        )
    }
}