package com.luz.proyectoadopt.models

data class Mascota(
    val id_mascota: Int = 0,
    val nombre: String = "",
    val especie: String = "",
    val descripcion_corta: String = "",
    val raza: String? = null,
    val edad: String = "",
    val tamano: String = ""
)
