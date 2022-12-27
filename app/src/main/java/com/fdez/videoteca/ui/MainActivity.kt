package com.fdez.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.fdez.videoteca.R
import com.fdez.videoteca.adapter.MoviesAdapter
import com.fdez.videoteca.databinding.ActivityMainBinding
import com.fdez.videoteca.model.Movie
import com.fdez.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MoviesAdapter
    private lateinit var bind: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        adapter = MoviesAdapter()
        bind.recyclerview.adapter = adapter

        adapter.refreshList(getListFromJson())
    }

    private fun getListFromJson(): ArrayList<Movie>{
        val json: String? = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }


}