package meh.daniel.com.kinopoiskapp.data.network

import meh.daniel.com.kinopoiskapp.data.network.model.GenreNW
import meh.daniel.com.kinopoiskapp.data.network.model.MovieNW
import retrofit2.http.GET
import retrofit2.http.Query

interface KinopoiskApi {

    @GET("v2.2/films/filters")
    suspend fun getGenres(): List<GenreNW>

    @GET("v2.2/films")
    suspend fun getMovie(
        @Query("genres") id: Int,
        @Query("order") order: String,
        @Query("page") page: Int,
    ): MovieNW

}