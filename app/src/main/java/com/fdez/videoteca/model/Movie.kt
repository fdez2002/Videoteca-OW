package com.fdez.videoteca.model

import java.io.Serializable
import java.time.Year

data class Movie(val id: Int, var name: String, val description: String?, val cover: String?, val year: Int?): Serializable //se extiende para transformar un objeto JSON a un objeto normal
