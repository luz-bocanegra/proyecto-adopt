package com.luz.proyectoadopt.screens.refugios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luz.proyectoadopt.R
import com.luz.proyectoadopt.models.Refugio
import com.luz.proyectoadopt.ui.theme.AppTheme
import com.luz.proyectoadopt.ui.theme.ProyectoAdoptTheme
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.luz.proyectoadopt.components.TopBar

private val refugios = listOf(
    Refugio(
        R.drawable.refugio1,
        "Refugio Santa Teresa",
        "Centro de rescate y adopción dedicado a perros y gatos en situación de calle, brindándoles rehabilitación y un hogar temporal.",
        56,
        "San Juan de Lurigancho, Lima",
        "986-345-647"
    ),
    Refugio(
        R.drawable.refugio2,
        "Huellitas Felices",
        "Organización sin fines de lucro enfocada en el rescate, cuidado y búsqueda de adopciones responsables para animales maltratados.",
        101,
        "Villa El Salvador, Lima",
        "977-322-677"
    ),
    Refugio(
        R.drawable.refugio3,
        "Patitas Descalzas",
        "Santuario y refugio temporal para animales rescatados de situaciones de abandono y crueldad urbana.",
        20,
        "San Isidro, Lima",
        "999-756-200"
    ),
    Refugio(
        R.drawable.refugio4,
        "Hogar Peludo",
        "Espacio seguro que acoge a mascotas rescatadas, promoviendo la tenencia responsable y campañas de esterilización.",
        47,
        "Comas, Lima",
        "990-886-634"
    ),
    Refugio(
        R.drawable.refugio5,
        "Arca de Noé Animal",
        "Refugio y centro de rehabilitación integral que ofrece atención médica veterinaria y segundas oportunidades.",
        120,
        "San Juan de Miraflores, Lima",
        "900-001-220"
    )
)

class RefugiosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAdoptTheme {
                RefugiosScreen(
                    onBackClick = { finish() }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefugiosScreen(onBackClick: () -> Unit) {
    var refugioSeleccionado by remember { mutableStateOf<Refugio?>(null) }
    val sheetState = rememberModalBottomSheetState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopBar(
                onBackClick = onBackClick,
                title = "Refugios",
                subtitle = "Guía")
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = AppTheme.spacing.regular,
                    end = AppTheme.spacing.regular,
                    top = AppTheme.spacing.small,
                    bottom = AppTheme.spacing.large
                ),
                verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.medium)
            ) {
                items(refugios, key = { it.nombre }) { refugio ->
                    RefugioCard(
                        refugio = refugio,
                        onVerMasClick = {refugioSeleccionado = refugio}
                    )
                }
            }
        }
    }

    val refugioActual = refugioSeleccionado
    if(refugioActual != null) {
        RefugioModal(
            refugio = refugioActual,
            sheetstate = sheetState,
            onDismiss = {refugioSeleccionado = null}
        )
    }

}


