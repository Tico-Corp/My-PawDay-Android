package com.tico.mypawday.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = lightPrimary,
    onPrimary = lightOnPrimary,
    primaryContainer = lightPrimaryContainer,
    onPrimaryContainer = lightOnPrimaryContainer,
    secondary = lightSecondary,
    onSecondary = lightOnSecondary,
    secondaryContainer = lightSecondaryContainer,
    onSecondaryContainer = lightOnSecondaryContainer,
    tertiary = lightTertiary,
    onTertiary = lightOnTertiary,
    tertiaryContainer = lightTertiaryContainer,
    onTertiaryContainer = lightOnTertiaryContainer,
    error = lightError,
    onError = lightOnError,
    errorContainer = lightErrorContainer,
    onErrorContainer = lightOnErrorContainer,
    background = lightBackground,
    onBackground = lightOnBackground,
    surface = lightSurface,
    onSurface = lightOnSurface,
    surfaceVariant = lightSurfaceVariant,
    onSurfaceVariant = lightOnSurfaceVariant,
    outline = lightOutline,
    outlineVariant = lightOutlineVariant,
    surfaceTint = lightSurfaceTint,
    inverseSurface = lightInverseSurface,
    inverseOnSurface = lightInverseOnSurface,
    inversePrimary = lightInversePrimary,
    surfaceDim = lightSurfaceDim,
    surfaceBright = lightSurfaceBright,
    surfaceContainerLowest = lightSurfaceContainerLowest,
    surfaceContainerLow = lightSurfaceContainerLow,
    surfaceContainer = lightSurfaceContainer,
    surfaceContainerHigh = lightSurfaceContainerHigh,
    surfaceContainerHighest = lightSurfaceContainerHighest,
    scrim = lightScrim,
)

private val DarkColorScheme = darkColorScheme(
    primary = darkPrimary,
    onPrimary = darkOnPrimary,
    primaryContainer = darkPrimaryContainer,
    onPrimaryContainer = darkOnPrimaryContainer,
    secondary = darkSecondary,
    onSecondary = darkOnSecondary,
    secondaryContainer = darkSecondaryContainer,
    onSecondaryContainer = darkOnSecondaryContainer,
    tertiary = darkTertiary,
    onTertiary = darkOnTertiary,
    tertiaryContainer = darkTertiaryContainer,
    onTertiaryContainer = darkOnTertiaryContainer,
    error = darkError,
    onError = darkOnError,
    errorContainer = darkErrorContainer,
    onErrorContainer = darkOnErrorContainer,
    background = darkBackground,
    onBackground = darkOnBackground,
    surface = darkSurface,
    onSurface = darkOnSurface,
    surfaceVariant = darkSurfaceVariant,
    onSurfaceVariant = darkOnSurfaceVariant,
    outline = darkOutline,
    outlineVariant = darkOutlineVariant,
    surfaceTint = darkSurfaceTint,
    inverseSurface = darkInverseSurface,
    inverseOnSurface = darkInverseOnSurface,
    inversePrimary = darkInversePrimary,
    surfaceDim = darkSurfaceDim,
    surfaceBright = darkSurfaceBright,
    surfaceContainerLowest = darkSurfaceContainerLowest,
    surfaceContainerLow = darkSurfaceContainerLow,
    surfaceContainer = darkSurfaceContainer,
    surfaceContainerHigh = darkSurfaceContainerHigh,
    surfaceContainerHighest = darkSurfaceContainerHighest,
    scrim = darkScrim,
)

private val LightMediumContrastColorScheme = lightColorScheme(
    primary = lightMediumContrastPrimary,
    onPrimary = lightMediumContrastOnPrimary,
    primaryContainer = lightMediumContrastPrimaryContainer,
    onPrimaryContainer = lightMediumContrastOnPrimaryContainer,
    secondary = lightMediumContrastSecondary,
    onSecondary = lightMediumContrastOnSecondary,
    secondaryContainer = lightMediumContrastSecondaryContainer,
    onSecondaryContainer = lightMediumContrastOnSecondaryContainer,
    tertiary = lightMediumContrastTertiary,
    onTertiary = lightMediumContrastOnTertiary,
    tertiaryContainer = lightMediumContrastTertiaryContainer,
    onTertiaryContainer = lightMediumContrastOnTertiaryContainer,
    error = lightMediumContrastError,
    onError = lightMediumContrastOnError,
    errorContainer = lightMediumContrastErrorContainer,
    onErrorContainer = lightMediumContrastOnErrorContainer,
    background = lightMediumContrastBackground,
    onBackground = lightMediumContrastOnBackground,
    surface = lightMediumContrastSurface,
    onSurface = lightMediumContrastOnSurface,
    surfaceVariant = lightMediumContrastSurfaceVariant,
    onSurfaceVariant = lightMediumContrastOnSurfaceVariant,
    outline = lightMediumContrastOutline,
    outlineVariant = lightMediumContrastOutlineVariant,
    surfaceTint = lightMediumContrastSurfaceTint,
    inverseSurface = lightMediumContrastInverseSurface,
    inverseOnSurface = lightMediumContrastInverseOnSurface,
    inversePrimary = lightMediumContrastInversePrimary,
    surfaceDim = lightMediumContrastSurfaceDim,
    surfaceBright = lightMediumContrastSurfaceBright,
    surfaceContainerLowest = lightMediumContrastSurfaceContainerLowest,
    surfaceContainerLow = lightMediumContrastSurfaceContainerLow,
    surfaceContainer = lightMediumContrastSurfaceContainer,
    surfaceContainerHigh = lightMediumContrastSurfaceContainerHigh,
    surfaceContainerHighest = lightMediumContrastSurfaceContainerHighest,
    scrim = lightMediumContrastScrim,
)

private val DarkMediumContrastColorScheme = darkColorScheme(
    primary = darkMediumContrastPrimary,
    onPrimary = darkMediumContrastOnPrimary,
    primaryContainer = darkMediumContrastPrimaryContainer,
    onPrimaryContainer = darkMediumContrastOnPrimaryContainer,
    secondary = darkMediumContrastSecondary,
    onSecondary = darkMediumContrastOnSecondary,
    secondaryContainer = darkMediumContrastSecondaryContainer,
    onSecondaryContainer = darkMediumContrastOnSecondaryContainer,
    tertiary = darkMediumContrastTertiary,
    onTertiary = darkMediumContrastOnTertiary,
    tertiaryContainer = darkMediumContrastTertiaryContainer,
    onTertiaryContainer = darkMediumContrastOnTertiaryContainer,
    error = darkMediumContrastError,
    onError = darkMediumContrastOnError,
    errorContainer = darkMediumContrastErrorContainer,
    onErrorContainer = darkMediumContrastOnErrorContainer,
    background = darkMediumContrastBackground,
    onBackground = darkMediumContrastOnBackground,
    surface = darkMediumContrastSurface,
    onSurface = darkMediumContrastOnSurface,
    surfaceVariant = darkMediumContrastSurfaceVariant,
    onSurfaceVariant = darkMediumContrastOnSurfaceVariant,
    outline = darkMediumContrastOutline,
    outlineVariant = darkMediumContrastOutlineVariant,
    surfaceTint = darkMediumContrastSurfaceTint,
    inverseSurface = darkMediumContrastInverseSurface,
    inverseOnSurface = darkMediumContrastInverseOnSurface,
    inversePrimary = darkMediumContrastInversePrimary,
    surfaceDim = darkMediumContrastSurfaceDim,
    surfaceBright = darkMediumContrastSurfaceBright,
    surfaceContainerLowest = darkMediumContrastSurfaceContainerLowest,
    surfaceContainerLow = darkMediumContrastSurfaceContainerLow,
    surfaceContainer = darkMediumContrastSurfaceContainer,
    surfaceContainerHigh = darkMediumContrastSurfaceContainerHigh,
    surfaceContainerHighest = darkMediumContrastSurfaceContainerHighest,
    scrim = darkMediumContrastScrim,
)

private val LightHighContrastColorScheme = lightColorScheme(
    primary = lightHighContrastPrimary,
    onPrimary = lightHighContrastOnPrimary,
    primaryContainer = lightHighContrastPrimaryContainer,
    onPrimaryContainer = lightHighContrastOnPrimaryContainer,
    secondary = lightHighContrastSecondary,
    onSecondary = lightHighContrastOnSecondary,
    secondaryContainer = lightHighContrastSecondaryContainer,
    onSecondaryContainer = lightHighContrastOnSecondaryContainer,
    tertiary = lightHighContrastTertiary,
    onTertiary = lightHighContrastOnTertiary,
    tertiaryContainer = lightHighContrastTertiaryContainer,
    onTertiaryContainer = lightHighContrastOnTertiaryContainer,
    error = lightHighContrastError,
    onError = lightHighContrastOnError,
    errorContainer = lightHighContrastErrorContainer,
    onErrorContainer = lightHighContrastOnErrorContainer,
    background = lightHighContrastBackground,
    onBackground = lightHighContrastOnBackground,
    surface = lightHighContrastSurface,
    onSurface = lightHighContrastOnSurface,
    surfaceVariant = lightHighContrastSurfaceVariant,
    onSurfaceVariant = lightHighContrastOnSurfaceVariant,
    outline = lightHighContrastOutline,
    outlineVariant = lightHighContrastOutlineVariant,
    surfaceTint = lightHighContrastSurfaceTint,
    inverseSurface = lightHighContrastInverseSurface,
    inverseOnSurface = lightHighContrastInverseOnSurface,
    inversePrimary = lightHighContrastInversePrimary,
    surfaceDim = lightHighContrastSurfaceDim,
    surfaceBright = lightHighContrastSurfaceBright,
    surfaceContainerLowest = lightHighContrastSurfaceContainerLowest,
    surfaceContainerLow = lightHighContrastSurfaceContainerLow,
    surfaceContainer = lightHighContrastSurfaceContainer,
    surfaceContainerHigh = lightHighContrastSurfaceContainerHigh,
    surfaceContainerHighest = lightHighContrastSurfaceContainerHighest,
    scrim = lightHighContrastScrim,
)

private val DarkHighContrastColorScheme = darkColorScheme(
    primary = darkHighContrastPrimary,
    onPrimary = darkHighContrastOnPrimary,
    primaryContainer = darkHighContrastPrimaryContainer,
    onPrimaryContainer = darkHighContrastOnPrimaryContainer,
    secondary = darkHighContrastSecondary,
    onSecondary = darkHighContrastOnSecondary,
    secondaryContainer = darkHighContrastSecondaryContainer,
    onSecondaryContainer = darkHighContrastOnSecondaryContainer,
    tertiary = darkHighContrastTertiary,
    onTertiary = darkHighContrastOnTertiary,
    tertiaryContainer = darkHighContrastTertiaryContainer,
    onTertiaryContainer = darkHighContrastOnTertiaryContainer,
    error = darkHighContrastError,
    onError = darkHighContrastOnError,
    errorContainer = darkHighContrastErrorContainer,
    onErrorContainer = darkHighContrastOnErrorContainer,
    background = darkHighContrastBackground,
    onBackground = darkHighContrastOnBackground,
    surface = darkHighContrastSurface,
    onSurface = darkHighContrastOnSurface,
    surfaceVariant = darkHighContrastSurfaceVariant,
    onSurfaceVariant = darkHighContrastOnSurfaceVariant,
    outline = darkHighContrastOutline,
    outlineVariant = darkHighContrastOutlineVariant,
    surfaceTint = darkHighContrastSurfaceTint,
    inverseSurface = darkHighContrastInverseSurface,
    inverseOnSurface = darkHighContrastInverseOnSurface,
    inversePrimary = darkHighContrastInversePrimary,
    surfaceDim = darkHighContrastSurfaceDim,
    surfaceBright = darkHighContrastSurfaceBright,
    surfaceContainerLowest = darkHighContrastSurfaceContainerLowest,
    surfaceContainerLow = darkHighContrastSurfaceContainerLow,
    surfaceContainer = darkHighContrastSurfaceContainer,
    surfaceContainerHigh = darkHighContrastSurfaceContainerHigh,
    surfaceContainerHighest = darkHighContrastSurfaceContainerHighest,
    scrim = darkHighContrastScrim,
)

@Immutable
data class CustomColorScheme(
    val gray10: Color = Color.Unspecified,
    val gray20: Color = Color.Unspecified,
    val gray30: Color = Color.Unspecified,
    val gray40: Color = Color.Unspecified,
    val gray50: Color = Color.Unspecified,
    val gray60: Color = Color.Unspecified,
    val yellowCreamy: Color = Color.Unspecified,
    val yellowCreamyButtermilk: Color = Color.Unspecified,
    val yellowLightGoldenrod: Color = Color.Unspecified,
    val yellowShinyGold: Color = Color.Unspecified,
)

private val LightCustomColors = CustomColorScheme(
    gray10 = lightGray10,
    gray20 = lightGray20,
    gray30 = lightGray30,
    gray40 = lightGray40,
    gray50 = lightGray50,
    gray60 = lightGray60,
    yellowCreamy = lightYellowCreamy,
    yellowCreamyButtermilk = lightYellowCreamyButtermilk,
    yellowLightGoldenrod = lightYellowLightGoldenrod,
    yellowShinyGold = lightYellowShinyGold,
)

val LocalCustomColorScheme = staticCompositionLocalOf { CustomColorScheme() }

private val DarkCustomColors = CustomColorScheme(
    gray10 = darkGray10,
    gray20 = darkGray20,
    gray30 = darkGray30,
    gray40 = darkGray40,
    gray50 = darkGray50,
    gray60 = darkGray60,
    yellowCreamy = darkYellowCreamy,
    yellowCreamyButtermilk = darkYellowCreamyButtermilk,
    yellowLightGoldenrod = darkYellowLightGoldenrod,
    yellowShinyGold = darkYellowShinyGold,
)

@Composable
fun MyPawDayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val customColorScheme = if (darkTheme) DarkCustomColors else LightCustomColors

    CompositionLocalProvider(LocalCustomColorScheme provides customColorScheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

object MyPawDayTheme {
    val colorScheme: CustomColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColorScheme.current
}