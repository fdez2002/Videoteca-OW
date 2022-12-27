package com.fdez.videoteca.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fdez.videoteca.R
import com.fdez.videoteca.databinding.ItemMovieBinding
import com.fdez.videoteca.model.Movie
import com.fdez.videoteca.utils.inflate

class MoviesAdapter : RecyclerView.Adapter<MoviewViewHolder>() {

    private val movieList = arrayListOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        val itemBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviewViewHolder(itemBinding)

    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        val movie: Movie = movieList[position]
        holder.bind(movie)
    }
    fun refreshList(movieList: ArrayList<Movie>){
        this.movieList.addAll(movieList)
        notifyDataSetChanged()//actualizamos el adaptador
    }
}