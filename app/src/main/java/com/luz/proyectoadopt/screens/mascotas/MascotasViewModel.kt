package com.luz.proyectoadopt.screens.mascotas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luz.proyectoadopt.data.repository.MascotasRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MascotasViewModel(
    private val repository: MascotasRepository = MascotasRepository()): ViewModel()
{
    private val _uiState = MutableStateFlow<MascotasUIState>(MascotasUIState.Loading)
    val uiState: StateFlow<MascotasUIState> = _uiState.asStateFlow()

    fun fetchMascotas() {
        viewModelScope.launch {
            _uiState.value = MascotasUIState.Loading
            _uiState.value = try {
                MascotasUIState.Success(repository.listMascotas())
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                MascotasUIState.Error("No se pudieron cargar los datos: " + e.message)
            }
        }
    }

    init {
        fetchMascotas()
    }
}