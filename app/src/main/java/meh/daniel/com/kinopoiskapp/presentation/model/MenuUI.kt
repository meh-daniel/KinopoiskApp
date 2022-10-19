package meh.daniel.com.kinopoiskapp.presentation.model

sealed class MenuUI{
    data class Menu(
        val name: String,
        val poster: String,
        val description: String = "Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века."
    ) : MenuUI()
    data class Genre(
        val id: Int,
        val genre: String,
        var onClick: Boolean = false,
    ) : MenuUI()
    object Promotion: MenuUI()
}
