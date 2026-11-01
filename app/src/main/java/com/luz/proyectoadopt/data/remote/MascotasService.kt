package com.luz.proyectoadopt.data.remote

import com.luz.proyectoadopt.models.Mascota
import retrofit2.http.GET

interface MascotasService {
    @GET(value = "mascotas")
    suspend fun getMascotas(): List<Mascota>
}