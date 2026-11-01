package com.luz.proyectoadopt.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luz.proyectoadopt.ui.theme.AppTheme

@Composable
fun StyledCard(
    modifier: Modifier,
    contenido: @Composable () -> Unit
) {
    Card (
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(AppTheme.spacing.medium),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Box(modifier.padding(AppTheme.spacing.regular)) {
            contenido()
        }
    }
}