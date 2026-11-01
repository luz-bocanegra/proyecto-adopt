package com.luz.proyectoadopt.screens.mascotas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.luz.proyectoadopt.components.StyledCard
import com.luz.proyectoadopt.models.Mascota
import com.luz.proyectoadopt.ui.theme.AppTheme

@Composable
fun MascotaCard(
    mascota: Mascota,
    modifier: Modifier = Modifier
) {
    StyledCard(modifier = modifier){
        Column(verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.extraSmall)) {
            Text(
                text = mascota.nombre,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = mascota.especie + " - " + mascota.edad + " - " + mascota.tamano,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.background.copy(0.5f)
            )
            Text(
                text = mascota.descripcion_corta,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.background.copy(0.5f)
            )
        }
    }
}