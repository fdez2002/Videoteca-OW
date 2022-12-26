package com.fdez.videoteca.utils

import android.content.Context
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