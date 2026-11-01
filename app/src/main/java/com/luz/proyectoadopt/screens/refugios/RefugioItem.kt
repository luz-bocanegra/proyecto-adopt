package com.luz.proyectoadopt.screens.refugios

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.luz.proyectoadopt.components.Boton
import com.luz.proyectoadopt.components.StyledCard
import com.luz.proyectoadopt.models.Refugio
import com.luz.proyectoadopt.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

@Composable
fun RefugioCard(
    refugio: Refugio,
    onVerMasClick: () -> Unit
) {
    StyledCard(modifier = Modifier) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1.9f)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    painterResource(refugio.imagen),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = refugio.nombre,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
            )
            Text(
                text = refugio.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.background.copy(0.5f)
            )
            Spacer(modifier = Modifier.height(AppTheme.spacing.regular))
            Boton(
                click = onVerMasClick,
                bgColor = MaterialTheme.colorScheme.tertiary,
                texto = "Ver más",
                frColor = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefugioModal(
    refugio: Refugio,
    onDismiss: () -> Unit,
    sheetstate: SheetState
){
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetstate
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.large)
            .navigationBarsPadding()) {
            Text(
                text = refugio.nombre,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(AppTheme.spacing.regular))
            Text(
                text = "Tenemos " + refugio.aforo.toString() + " peluditos esperando por ti",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.background.copy(0.6f),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(AppTheme.spacing.regular))
            Text(
                text = refugio.descripcion,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.background.copy(0.6f)
            )
            Spacer(modifier = Modifier.height(AppTheme.spacing.regular))
            Text(
                text = refugio.direccion,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.background.copy(0.6f),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(AppTheme.spacing.regular))
            Text(
                text = refugio.contacto,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary.copy(0.6f),
                fontWeight = FontWeight.Bold
            )

        }
    }

}


