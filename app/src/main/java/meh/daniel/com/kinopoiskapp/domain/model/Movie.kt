package meh.daniel.com.kinopoiskapp.domain.model

data class Movie(
    val name: String,
    val poster: String,
    val description: String = "Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века."
)