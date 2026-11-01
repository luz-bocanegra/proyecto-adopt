package com.luz.proyectoadopt.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luz.proyectoadopt.R

// Set of Material typography styles to start with
val urbanistFamily = FontFamily (
    Font(R.font.urbanist_extralight, FontWeight.ExtraLight),
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_black, FontWeight.Black)
)
val Typography = Typography(

    // -------------------------------------------------
    // DISPLAY
    // Logo / nombre principal
    // -------------------------------------------------

    displayLarge = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 72.sp,
        lineHeight = 84.sp,
        letterSpacing = (-4).sp
    ),


    // -------------------------------------------------
    // HEADLINES
    // -------------------------------------------------

    headlineLarge = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Black,
        fontSize = 36.sp,
        lineHeight = 40.sp,
        letterSpacing = (-2).sp
    ),

    headlineMedium = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Black,
        fontSize = 34.sp,
        lineHeight = 38.sp,
        letterSpacing = (-1).sp
    ),

    headlineSmall = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),


    // -------------------------------------------------
    // TITLES
    // -------------------------------------------------

    titleLarge = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    titleMedium = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),

    titleSmall = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),


    // -------------------------------------------------
    // BODY
    // -------------------------------------------------

    bodyLarge = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),

    bodySmall = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    ),


    // -------------------------------------------------
    // LABELS
    // -------------------------------------------------

    labelLarge = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    labelMedium = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    ),

    labelSmall = TextStyle(
        fontFamily = com.luz.proyectoadopt.ui.theme.urbanistFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.5.sp
    )
)