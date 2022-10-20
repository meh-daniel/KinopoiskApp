package meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.ItemMovieBinding

class MovieAdapter: ListAdapter<MenuUI.Menu, RecyclerView.ViewHolder>(MovieUIDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        R.layout.item_movie -> MovieViewHolder.onCreateViewHolder(parent)
        else -> throw Throwable("onCreateViewHolder exception - unknown view type by name: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder) {
        is MovieViewHolder -> holder.bind(item = getItem(position) as MenuUI.Menu)
        else -> throw Throwable("onBindViewHolder exception - unknown holder of view by name ${holder.itemView.id}")
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is MenuUI.Menu -> R.layout.item_movie
        else -> throw Exception("getItemViewType unknown item class exception from position: $position")
    }
}

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MenuUI.Menu){
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

class MovieUIDiffUtil: DiffUtil.ItemCallback<MenuUI.Menu>() {
    override fun areItemsTheSame(oldItem: MenuUI.Menu, newItem: MenuUI.Menu): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: MenuUI.Menu, newItem: MenuUI.Menu): Boolean = oldItem == newItem
}