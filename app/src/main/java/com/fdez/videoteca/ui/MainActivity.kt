package com.fdez.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fdez.videoteca.R
import com.fdez.videoteca.model.Movie
import com.fdez.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getListFromJson(): ArrayList<Movie>{
        val json: String? = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }
}