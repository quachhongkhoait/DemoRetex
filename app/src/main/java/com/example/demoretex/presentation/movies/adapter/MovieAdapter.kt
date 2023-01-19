package com.example.demoretex.presentation.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demoretex.data.model.Movie
import com.example.demoretex.databinding.ItemMovieBinding
import com.example.demoretex.shared.safeClick

class MovieAdapter(private val onItemClick: (Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.ItemViewHolder>(object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(getItem(position), (position == itemCount - 1))
    }

    class ItemViewHolder(
        private val binding: ItemMovieBinding,
        val onItemClick: (Movie) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(itemMovie: Movie, isLastItem: Boolean) {
            binding.apply {
                movie = itemMovie
                if (isLastItem) divider.visibility = View.GONE
                executePendingBindings()
                root.safeClick { onItemClick(itemMovie) }
            }
        }
    }
}