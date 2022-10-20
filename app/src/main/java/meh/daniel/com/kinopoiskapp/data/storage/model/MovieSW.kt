package meh.daniel.com.kinopoiskapp.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = MovieSW.TABLE_NAME,
)
data class MovieSW(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val poster: String,
) {
    companion object {
        const val TABLE_NAME = "movie"
    }
}