package com.luz.proyectoadopt.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.luz.proyectoadopt.DashboardModule
import com.luz.proyectoadopt.ui.theme.AppTheme

@Composable
fun PillCard(
    module: DashboardModule,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card (
        onClick = onNavigate,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(percent = 50),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.background
        )
    ) {
        Row( modifier = Modifier.fillMaxWidth()
            .padding(AppTheme.spacing.extraSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Box(modifier = Modifier.size(AppTheme.sizes.iconContainerMedium)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.tertiary.copy(0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = module.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background,
                    modifier = Modifier.size(AppTheme.sizes.iconRegular)
                )
            }
            Text(
                stringResource(module.titleRes),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.background,
                maxLines = 1, minLines = 1,
                modifier = Modifier.padding(start = AppTheme.spacing.small)
            )
        }
    }
}