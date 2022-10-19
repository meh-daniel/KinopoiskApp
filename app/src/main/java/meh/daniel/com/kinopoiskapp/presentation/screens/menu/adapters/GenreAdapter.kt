package meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.ItemGenreBinding

class GenreAdapter(
    private val onClickGenre: (id: Int) -> Unit
) : ListAdapter<MenuUI.Genre, RecyclerView.ViewHolder>(GenreUIDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        R.layout.item_genre -> GenreViewHolder.onCreateViewHolder(parent, onClickGenre)
        else -> throw Throwable("onCreateViewHolder exception - unknown view type by name: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder) {
        is GenreViewHolder -> holder.bind(item = getItem(position) as MenuUI.Genre)
        else -> throw Throwable("onBindViewHolder exception - unknown holder of view by name ${holder.itemView.id}")
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is MenuUI.Genre -> R.layout.item_genre
        else -> throw Exception("getItemViewType unknown item class exception from position: $position")
    }
}

class GenreViewHolder(private val binding: ItemGenreBinding, private val onClickGenre: (id: Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MenuUI.Genre) {
        with(binding) {
            genreButtonText.text = item.genre
            if(!item.onClick) {
                genreButtonText.setTextColor(Color.parseColor("#C3C4C9"))
                genreButton.background.setTint(Color.parseColor("#FFFFFFFF"))
            } else {
                genreButtonText.setTextColor(Color.parseColor("#FD3A69"))
                genreButton.background.setTint(Color.parseColor("#33FC3A67"))
            }
            onClick(item)
        }
    }

    private fun onClick(item: MenuUI.Genre) {
        binding.root.setOnClickListener {
            onClickGenre(item.id)
            item.onClick = !item.onClick
        }
    }

    companion object {
        fun onCreateViewHolder(parent: ViewGroup, onClickGenre: (id: Int) -> Unit): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemGenreBinding.inflate(layoutInflater, parent, false)
            return GenreViewHolder(binding, onClickGenre)
        }
    }
}

class GenreUIDiffUtil: DiffUtil.ItemCallback<MenuUI.Genre>() {
    override fun areItemsTheSame(oldItem: MenuUI.Genre, newItem: MenuUI.Genre): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: MenuUI.Genre, newItem: MenuUI.Genre): Boolean = oldItem == newItem
}