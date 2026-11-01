package com.luz.proyectoadopt.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Boton(
    click : () -> Unit,
    bgColor: Color,
    texto: String,
    frColor: Color
) {
    Button(
        onClick = click,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor
        )
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelLarge,
            color = frColor
        )
    }
}