package com.luz.proyectoadopt.screens.mascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.luz.proyectoadopt.models.Mascota
import com.luz.proyectoadopt.ui.theme.ProyectoAdoptTheme
import com.luz.proyectoadopt.ui.theme.AppTheme


class MascotasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel= ViewModelProvider(this)[MascotasViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            ProyectoAdoptTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                MascotasScreen(
                    uiState = uiState,
                    onReintentar = { viewModel.fetchMascotas() },
                    onBackClick = { finish() }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MascotasScreen(
    uiState: MascotasUIState,
    onReintentar: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopAppBar(
                title = {
                    Column() {
                        Text(
                            "Mascotas",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        Text(
                            "Directorio",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.background.copy(0.7f)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick,
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.tertiary
                        )
                        ) {
                        Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            when(uiState) {
                 MascotasUIState.Loading -> CircularProgressIndicator(
                    Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.tertiary
                )
                is MascotasUIState.Error -> Column(Modifier
                    .align(Alignment.Center)
                    .padding(AppTheme.spacing.large),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(imageVector = Icons.Outlined.Business,
                        contentDescription = null,
                        modifier = Modifier.size(AppTheme.sizes.iconContainerMedium),
                        tint = MaterialTheme.colorScheme.tertiary)
                    Spacer(Modifier.height(AppTheme.spacing.large))
                    Text("No se pudieron cargar las mascotas",
                        style = MaterialTheme.typography.titleMedium)
                    FilledTonalButton(onClick = onReintentar) {
                        Text("Reintentar")
                    }
                }
                is MascotasUIState.Success -> ListaMascotas(uiState.mascotas)
            }
        }
    }
}

@Composable
fun ListaMascotas(
    mascotas: List<Mascota>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = AppTheme.spacing.regular,
            end = AppTheme.spacing.regular,
            top = AppTheme.spacing.small,
            bottom = AppTheme.spacing.large
        ),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.regular)
    ) {
        items(mascotas, key = {it.id_mascota}) { mascota ->
            MascotaCard(mascota)
        }
    }
}
