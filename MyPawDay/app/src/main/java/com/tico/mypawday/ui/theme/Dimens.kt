package com.tico.mypawday.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class TopBarDimens(
    val myPageIconSize: Dp = 55.dp,
    val logoHeight: Dp = 55.dp,
)

@Immutable
data class FabDimens(
    val mainFabSize: Dp = 70.dp,
    val subFabSize: Dp = 48.dp,
    val mainIconSize: Dp = 36.dp,
    val subIconSize: Dp = 30.dp,
)

@Immutable
data class FilterChipDimens(
    val textStyle: TextStyle = MyPawDayTypography.robotoRegular14,
    val spacing: Dp = 8.dp,
    val dropdownIconSize: Dp = 19.dp,
    val verticalPadding: Dp = 0.dp,
    val horizontalPadding: Dp = 10.dp,
)

@Immutable
data class ContentPaddingDimens(
    val contentVerticalPadding: Dp = 18.dp,
    val contentHorizontalPadding: Dp = 18.dp,
)

@Immutable
data class SplashDimens(
    val logoWidthFraction: Float = 0.65f,
    val logoHeightFraction: Float = 0.7f,
)

@Immutable
data class LoginDimens(
    val contentWidthFraction: Float = 1f,
)

object MyPawDayDimens {

    @Composable
    fun topBar(maxWidth: Dp): TopBarDimens = when {
        maxWidth >= 840.dp -> TopBarDimens(
            myPageIconSize = 63.dp,
            logoHeight = 63.dp,
        )

        maxWidth >= 600.dp -> TopBarDimens(
            myPageIconSize = 63.dp,
            logoHeight = 63.dp,
        )

        else -> TopBarDimens()
    }

    @Composable
    fun fab(maxWidth: Dp): FabDimens = when {
        maxWidth >= 840.dp -> FabDimens(
            mainFabSize = 82.dp,
            subFabSize = 56.dp,
            mainIconSize = 48.dp,
            subIconSize = 42.dp,
        )

        maxWidth >= 600.dp -> FabDimens(
            mainFabSize = 74.dp,
            subFabSize = 52.dp,
            mainIconSize = 44.dp,
            subIconSize = 38.dp,
        )

        else -> FabDimens()
    }

    @Composable
    fun contentPadding(maxWidth: Dp): ContentPaddingDimens = when {
        maxWidth >= 840.dp -> ContentPaddingDimens(
            contentVerticalPadding = 24.dp,
            contentHorizontalPadding = 24.dp,
        )

        maxWidth >= 600.dp -> ContentPaddingDimens(
            contentVerticalPadding = 18.dp,
            contentHorizontalPadding = 18.dp,
        )

        else -> ContentPaddingDimens()
    }

    @Composable
    fun splash(maxWidth: Dp): SplashDimens = when {
        maxWidth >= 840.dp -> SplashDimens(logoWidthFraction = 0.35f)
        maxWidth >= 600.dp -> SplashDimens(logoWidthFraction = 0.45f)
        else -> SplashDimens()
    }

    @Composable
    fun login(maxWidth: Dp): LoginDimens = when {
        maxWidth >= 840.dp -> LoginDimens(contentWidthFraction = 0.5f)
        maxWidth >= 600.dp -> LoginDimens(contentWidthFraction = 0.65f)
        else -> LoginDimens()
    }

    @Composable
    fun filterChip(maxWidth: Dp): FilterChipDimens = when {
        maxWidth >= 840.dp -> FilterChipDimens(
            textStyle = MyPawDayTypography.robotoRegular16,
            spacing = 12.dp,
            dropdownIconSize = 23.dp,
        )

        maxWidth >= 600.dp -> FilterChipDimens(
            textStyle = MyPawDayTypography.robotoRegular14,
            spacing = 10.dp,
            dropdownIconSize = 21.dp,
        )

        else -> FilterChipDimens()
    }
}