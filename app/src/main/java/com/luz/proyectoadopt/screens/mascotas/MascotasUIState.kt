package com.luz.proyectoadopt.screens.mascotas

import com.luz.proyectoadopt.models.Mascota

sealed interface MascotasUIState {
    data object Loading: MascotasUIState
    data class  Success(val mascotas: List<Mascota>): MascotasUIState
    data class Error(val mensaje: String): MascotasUIState
}