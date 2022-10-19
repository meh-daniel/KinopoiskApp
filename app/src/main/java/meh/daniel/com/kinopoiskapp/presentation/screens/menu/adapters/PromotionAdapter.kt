package meh.daniel.com.kinopoiskapp.presentation.screens.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import meh.daniel.com.kinopoiskapp.presentation.model.MenuUI
import meh.daniel.com.sundriesstoreapp.R
import meh.daniel.com.sundriesstoreapp.databinding.ItemPromotionBinding

class PromotionAdapter : ListAdapter<MenuUI.Promotion, RecyclerView.ViewHolder>(PromotionUIDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        R.layout.item_promotion -> PromotionViewHolder.onCreateViewHolder(parent)
        else -> throw Throwable("onCreateViewHolder exception - unknown view type by name: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder) {
        is PromotionViewHolder -> holder.bind(item = getItem(position) as MenuUI.Promotion)
        else -> throw Throwable("onBindViewHolder exception - unknown holder of view by name ${holder.itemView.id}")
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is MenuUI.Promotion -> R.layout.item_promotion
        else -> throw Exception("getItemViewType unknown item class exception from position: $position")
    }
}

class PromotionViewHolder(private val binding: ItemPromotionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MenuUI.Promotion){

    }
    companion object {
        fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPromotionBinding.inflate(layoutInflater, parent, false)
            return PromotionViewHolder(binding)
        }
    }
}

class PromotionUIDiffUtil: DiffUtil.ItemCallback<MenuUI.Promotion>() {
    override fun areItemsTheSame(oldItem: MenuUI.Promotion, newItem: MenuUI.Promotion): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: MenuUI.Promotion, newItem: MenuUI.Promotion): Boolean = oldItem == newItem
}