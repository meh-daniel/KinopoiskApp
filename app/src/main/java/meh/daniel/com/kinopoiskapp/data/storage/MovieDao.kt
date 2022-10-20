package meh.daniel.com.kinopoiskapp.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import meh.daniel.com.kinopoiskapp.data.storage.model.GenreSW
import meh.daniel.com.kinopoiskapp.data.storage.model.MovieSW

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenres(genres: List<GenreSW>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieSW>)

    @Query("SELECT * FROM genre")
    suspend  fun getAllGenres() : List<GenreSW>

    @Query("SELECT * FROM movie")
    suspend  fun getAllMovies() : List<MovieSW>

    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()

    @Transaction
    suspend fun updateLastMovies(movies: List<MovieSW>) {
        deleteAllMovies()
        insertMovies(movies)
    }

}