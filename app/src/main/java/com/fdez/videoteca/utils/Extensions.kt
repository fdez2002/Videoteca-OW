package com.fdez.videoteca.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.fdez.videoteca.GlideApp
import com.fdez.videoteca.R
import java.io.InputStream
import java.nio.charset.Charset

fun Context.getJsonFromAssets(file: String): String? {
    var json = ""
    val stream: InputStream = assets.open(file)
    val size: Int = stream.available()
    val buffer = ByteArray(size)
    stream.read(buffer)
    stream.close()

    json = String(buffer, Charset.defaultCharset())
    return json
}

//carga la imagen en formato string
fun ImageView.loadImage(image: String) {
    GlideApp.with(this).load(image).override(100,200).into(this)
}


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true): View =
  LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
