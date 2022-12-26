package com.fdez.videoteca.model

import java.io.Serializable

data class Movie( val id: Int, val name: String, val description: String, val cover: String): Serializable //se extiende para transformar un objeto JSON a un objeto normal
