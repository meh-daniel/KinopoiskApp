package meh.daniel.com.kinopoiskapp.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import meh.daniel.com.kinopoiskapp.data.storage.model.GenreSW
import meh.daniel.com.kinopoiskapp.data.storage.model.MovieSW

@Database(
    entities = arrayOf(
        GenreSW::class,
        MovieSW::class,
    ),
    version = MovieDataBase.DB_VERSION,
    exportSchema = false,
)
abstract class MovieDataBase: RoomDatabase() {
    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "movies.db"

        @Volatile private var instance : MovieDataBase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            DB_NAME
        ).build()
    }

    abstract fun movieDao(): MovieDao
}