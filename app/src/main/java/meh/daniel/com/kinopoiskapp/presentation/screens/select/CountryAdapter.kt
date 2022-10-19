package meh.daniel.com.kinopoiskapp.presentation.screens.select

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import meh.daniel.com.kinopoiskapp.presentation.model.CountryUI
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.ItemCountryBinding

class CountryAdapter() : ListAdapter<CountryUI, RecyclerView.ViewHolder>(CountryUIDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        R.layout.item_country -> CountryViewHolder.onCreateViewHolder(parent)
        else -> throw Throwable("onCreateViewHolder exception - unknown view type by name: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder) {
        is CountryViewHolder -> holder.bind(item = getItem(position) as CountryUI.Country)
        else -> throw Throwable("onBindViewHolder exception - unknown holder of view by name ${holder.itemView.id}")
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is CountryUI.Country -> R.layout.item_movie
        else -> throw Exception("getItemViewType unknown item class exception from position: $position")
    }

}

class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CountryUI.Country){
        with(binding){
            country.text = item.name
        }
    }
    companion object {
        fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCountryBinding.inflate(layoutInflater, parent, false)
            return CountryViewHolder(binding)
        }
    }
}

class CountryUIDiffUtil: DiffUtil.ItemCallback<CountryUI>() {
    override fun areItemsTheSame(oldItem: CountryUI, newItem: CountryUI): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: CountryUI, newItem: CountryUI): Boolean = oldItem == newItem
}