package com.example.jualan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = SecondaryGreen,
    secondary = PrimaryTeal,
    tertiary = PrimaryGreen,
    background = Color(0xFF121412),
    surface = Color(0xFF1A1C1A)
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    secondary = PrimaryTeal,
    tertiary = SecondaryGreen,
    background = AppBackground,
    surface = AppSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF202124),
    onSurface = Color(0xFF202124)
)

@Composable
fun JualanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}