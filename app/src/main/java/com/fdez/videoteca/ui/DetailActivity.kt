package com.fdez.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fdez.videoteca.R
import com.fdez.videoteca.databinding.ActivityDetailBinding
import com.fdez.videoteca.databinding.ActivityMainBinding
import com.fdez.videoteca.model.Movie
import com.fdez.videoteca.utils.loadImage

class DetailActivity : AppCompatActivity() {
    private lateinit var bind: ActivityDetailBinding


    private var movie: Movie? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        retrieMovie()
        renderUi()
    }

    private fun retrieMovie(){
        movie = intent.getSerializableExtra("movie") as Movie?

    }

    private fun renderUi(){
        bind.detailName.text = movie?.name
        bind.detailDescription.text = movie?.description

        movie?.cover?.let { mCover -> bind.detailImage.loadImage(mCover)}

    }
}