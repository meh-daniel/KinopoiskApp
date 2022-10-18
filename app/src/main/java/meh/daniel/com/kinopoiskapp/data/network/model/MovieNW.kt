package meh.daniel.com.kinopoiskapp.data.network.model


import com.google.gson.annotations.SerializedName

data class MovieNW(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalPages")
    val totalPages: Int
) {
    data class Item(
        @SerializedName("countries")
        val countries: List<Country>,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("imdbId")
        val imdbId: String?,
        @SerializedName("kinopoiskId")
        val kinopoiskId: Int,
        @SerializedName("nameEn")
        val nameEn: Any?,
        @SerializedName("nameOriginal")
        val nameOriginal: String?,
        @SerializedName("nameRu")
        val nameRu: String,
        @SerializedName("posterUrl")
        val posterUrl: String,
        @SerializedName("posterUrlPreview")
        val posterUrlPreview: String,
        @SerializedName("ratingImdb")
        val ratingImdb: Double?,
        @SerializedName("ratingKinopoisk")
        val ratingKinopoisk: Double,
        @SerializedName("type")
        val type: String,
        @SerializedName("year")
        val year: Int
    ) {
        data class Country(
            @SerializedName("country")
            val country: String
        )

        data class Genre(
            @SerializedName("genre")
            val genre: String
        )
    }
}