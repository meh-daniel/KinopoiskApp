package meh.daniel.com.kinopoiskapp.presentation.screens.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import meh.daniel.com.kinopoiskapp.presentation.model.MovieUI
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.ItemGenreBinding
import meh.daniel.com.sundriesstoreapp.databinding.ItemMovieBinding
import meh.daniel.com.sundriesstoreapp.databinding.ItemPromotionBinding

class MenuAdapter() : ListAdapter<MovieUI, RecyclerView.ViewHolder>(HeroUIDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        R.layout.item_movie -> MovieViewHolder.onCreateViewHolder(parent)
        R.layout.item_genre -> GenreViewHolder.onCreateViewHolder(parent)
        R.layout.item_promotion -> PromotionViewHolder.onCreateViewHolder(parent)
        else -> throw Throwable("onCreateViewHolder exception - unknown view type by name: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder) {
        is MovieViewHolder -> holder.bind(item = getItem(position) as MovieUI.Movie)
        is GenreViewHolder -> holder.bind(item = getItem(position) as MovieUI.Genre)
        is PromotionViewHolder -> holder.bind(item = getItem(position) as MovieUI.Promotion)
        else -> throw Throwable("onBindViewHolder exception - unknown holder of view by name ${holder.itemView.id}")
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is MovieUI.Movie -> R.layout.item_movie
        is MovieUI.Genre -> R.layout.item_genre
        is MovieUI.Promotion -> R.layout.item_promotion
        else -> throw Exception("getItemViewType unknown item class exception from position: $position")
    }
}

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieUI.Movie){
        with(binding){
            movieName.text = item.name
            movieDescription.text = item.description
            Glide.with(moviePoster)
                .load(item.poster)
                .into(moviePoster)
        }
    }
    companion object {
        fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
            return MovieViewHolder(binding)
        }
    }
}

class GenreViewHolder(private val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieUI.Genre) {
        binding.genreButton.text = item.genre
    }
    companion object {
        fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemGenreBinding.inflate(layoutInflater, parent, false)
            return GenreViewHolder(binding)
        }
    }
}

class PromotionViewHolder(private val binding: ItemPromotionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieUI.Promotion){

    }
    companion object {
        fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPromotionBinding.inflate(layoutInflater, parent, false)
            return PromotionViewHolder(binding)
        }
    }
}

class HeroUIDiffUtil: DiffUtil.ItemCallback<MovieUI>() {
    override fun areItemsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean = oldItem == newItem
}