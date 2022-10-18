package meh.daniel.com.kinopoiskapp.data.network

import meh.daniel.com.kinopoiskapp.data.network.model.GenreNW
import meh.daniel.com.kinopoiskapp.data.network.model.MovieNW
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KinopoiskApi {

    @Headers("X-API-KEY: b08fbc92-6904-4127-96b4-56dc9836aee4")
    @GET("v2.2/films/filters")
    suspend fun getGenres(): GenreNW

    @Headers("X-API-KEY: b08fbc92-6904-4127-96b4-56dc9836aee4")
    @GET("v2.2/films")
    suspend fun getMovie(
        @Query("genres") idGenre: Int,
        @Query("order") order: String,
        @Query("page") page: Int,
    ): MovieNW

}