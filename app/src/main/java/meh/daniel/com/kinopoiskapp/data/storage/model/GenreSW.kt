package meh.daniel.com.kinopoiskapp.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = GenreSW.TABLE_NAME,
    indices = [
        Index("name", unique = true )
    ]
)
data class GenreSW(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    val name: String,
) {
    companion object {
        const val TABLE_NAME = "genre"
    }
}