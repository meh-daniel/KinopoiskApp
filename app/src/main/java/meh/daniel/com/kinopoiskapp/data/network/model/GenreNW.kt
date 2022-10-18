package meh.daniel.com.kinopoiskapp.data.network.model


import com.google.gson.annotations.SerializedName

data class GenreNW(
    @SerializedName("countries")
    val countries: List<Country>,
    @SerializedName("genres")
    val genres: List<Genre>
) {
    data class Country(
        @SerializedName("country")
        val country: String,
        @SerializedName("id")
        val id: Int
    )

    data class Genre(
        @SerializedName("genre")
        val genre: String,
        @SerializedName("id")
        val id: Int
    )
}