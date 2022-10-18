package meh.daniel.com.kinopoiskapp.data

import meh.daniel.com.kinopoiskapp.data.network.KinopoiskApi
import meh.daniel.com.kinopoiskapp.data.storage.MovieDataBase
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import meh.daniel.com.kinopoiskapp.domain.model.Country
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

private const val ORDER = ""
private const val PAGE = 1

class MovieRepositoryImpl(
    private val api: KinopoiskApi,
    private val db: MovieDataBase
): MovieRepository {

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
}