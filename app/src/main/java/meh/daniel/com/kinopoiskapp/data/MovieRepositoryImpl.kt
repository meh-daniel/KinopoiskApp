package meh.daniel.com.kinopoiskapp.data

import meh.daniel.com.kinopoiskapp.data.network.KinopoiskApi
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import meh.daniel.com.kinopoiskapp.domain.model.Genre
import meh.daniel.com.kinopoiskapp.domain.model.Movie

class MovieRepositoryImpl(
    private val api: KinopoiskApi
): MovieRepository {
    override fun getBy(genre: Genre): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getGenre(): List<Genre> {
        TODO("Not yet implemented")
    }
}