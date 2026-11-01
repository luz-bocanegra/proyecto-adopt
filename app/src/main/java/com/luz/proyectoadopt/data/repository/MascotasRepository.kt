package com.luz.proyectoadopt.data.repository

import com.luz.proyectoadopt.data.remote.MascotasService
import com.luz.proyectoadopt.data.remote.RetrofitClient
import com.luz.proyectoadopt.models.Mascota

class MascotasRepository (
    private val service: MascotasService = RetrofitClient.mascotasService
) {
    suspend fun listMascotas(): List<Mascota> = service.getMascotas()
}