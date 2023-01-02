package com.fdez.videoteca.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.fdez.videoteca.adapter.MoviesAdapter
import com.fdez.videoteca.databinding.ActivityMainBinding
import com.fdez.videoteca.model.Movie
import com.fdez.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MoviesAdapter
    private lateinit var bind: ActivityMainBinding
    private  val copyList = arrayListOf<Movie>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        adapter = MoviesAdapter(::onMovieClick)
        bind.recyclerview.adapter = adapter

        adapter.refreshList(getListFromJson())

        //buscador de peliculas
        bind.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                //el texto que le enviamos es newText
                newText?.let {//nos aseguramos que no sea null
                    val filtered :List<Movie> = copyList.filter { it.name.toLowerCase(Locale.getDefault()).contains(newText) }
                    adapter.filterByName(filtered)

                }
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }
        })
    }

    private fun getListFromJson(): ArrayList<Movie>{
        val json: String? = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        copyList.addAll(movieList)
        return ArrayList(movieList)
    }

    private fun onMovieClick(movie: Movie){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)

    }


}