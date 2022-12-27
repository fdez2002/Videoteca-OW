package com.fdez.videoteca.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fdez.videoteca.databinding.ItemMovieBinding
import com.fdez.videoteca.model.Movie
import com.fdez.videoteca.utils.loadImage

class MoviewViewHolder(private val itemBinding: ItemMovieBinding): RecyclerView.ViewHolder(itemBinding.root){

    //setea los valores por pantalla
    fun bind(movie: Movie){
        itemBinding.movieTitle.text = movie.name
        movie.cover?.let {
            itemBinding.movieCover.loadImage(movie.cover)
        }

    }
}