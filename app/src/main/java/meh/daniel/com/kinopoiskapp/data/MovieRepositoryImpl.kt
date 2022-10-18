package meh.daniel.com.kinopoiskapp.data

import meh.daniel.com.kinopoiskapp.data.network.KinopoiskApi
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

private const val ORDER = ""
private const val PAGE = 1

class MovieRepositoryImpl(
    private val api: KinopoiskApi
): MovieRepository {

    override suspend fun getBy(genre: Genre): List<Movie> {
        return api.getMovie(
            idGenre = genre.id,
            order = ORDER,
            page = PAGE
        ).toDomain()
    }

    override suspend fun getGenre(): List<Genre> {
        return api.getGenres().toDomain()
    }

}