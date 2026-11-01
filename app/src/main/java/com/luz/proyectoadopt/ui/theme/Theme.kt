package com.luz.proyectoadopt.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(

    primary = AppBackground,
    onPrimary = AppForeground,

    primaryContainer = AppPrimary,
    onPrimaryContainer = AppBackground,

    secondary = AppPrimary,
    onSecondary = AppSecondary,

    secondaryContainer = AppPrimary,
    onSecondaryContainer = AppBackground,

    tertiary = AppPrimary,
    onTertiary = AppBackground,

    background = AppForeground,
    onBackground = AppBackground,

    surface = AppPrimary,
    onSurface = AppBackground,

    surfaceVariant = AppForeground,
    onSurfaceVariant = AppSecondary,

    outline = AppBackground,

    surfaceTint = AppBackground
)
@Composable
fun ProyectoAdoptTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

object AppTheme {
    val spacing: AppSpacing
        @Composable @ReadOnlyComposable get() = LocalAppSpacing.current

    val sizes: AppComponentSizes
        @Composable @ReadOnlyComposable get() = LocalAppComponentSizes.current
}