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
data class SplashDimens(
    val logoWidthFraction: Float = 0.65f,
    val logoHeightFraction: Float = 0.7f,
)

@Immutable
data class LoginDimens(
    val contentWidthFraction: Float = 1f,
)

@Immutable
data class DialogDimens(
    val titleStyle: TextStyle = MyPawDayTypography.robotoRegular18,
    val buttonStyle: TextStyle = MyPawDayTypography.robotoRegular16,
    val horizontalPadding: Dp = 40.dp,
    val verticalPadding: Dp = 50.dp,
    val titleButtonSpacing: Dp = 25.dp,
    val buttonSpacing: Dp = 56.dp,
    val cornerRadius: Dp = 20.dp,
    val buttonCornerRadius: Dp = 10.dp,
    val buttonHorizontalPadding: Dp = 20.dp,
    val buttonVerticalPadding: Dp = 14.dp,
)

object MyPawDayDimens {

    val tabletMinWidth = 600.dp
    val largeTabletMinWidth = 840.dp

    @Composable
    fun topBar(maxWidth: Dp): TopBarDimens = when {
        maxWidth >= largeTabletMinWidth -> TopBarDimens(
            myPageIconSize = 63.dp,
            logoHeight = 63.dp,
        )

        maxWidth >= tabletMinWidth -> TopBarDimens(
            myPageIconSize = 63.dp,
            logoHeight = 63.dp,
        )

        else -> TopBarDimens()
    }

    @Composable
    fun fab(maxWidth: Dp): FabDimens = when {
        maxWidth >= largeTabletMinWidth -> FabDimens(
            mainFabSize = 82.dp,
            subFabSize = 56.dp,
            mainIconSize = 48.dp,
            subIconSize = 42.dp,
        )

        maxWidth >= tabletMinWidth -> FabDimens(
            mainFabSize = 74.dp,
            subFabSize = 52.dp,
            mainIconSize = 44.dp,
            subIconSize = 38.dp,
        )

        else -> FabDimens()
    }

    @Composable
    fun splash(maxWidth: Dp): SplashDimens = when {
        maxWidth >= largeTabletMinWidth -> SplashDimens(logoWidthFraction = 0.35f)
        maxWidth >= tabletMinWidth -> SplashDimens(logoWidthFraction = 0.45f)
        else -> SplashDimens()
    }

    @Composable
    fun login(maxWidth: Dp): LoginDimens = when {
        maxWidth >= largeTabletMinWidth -> LoginDimens(contentWidthFraction = 0.5f)
        maxWidth >= tabletMinWidth -> LoginDimens(contentWidthFraction = 0.65f)
        else -> LoginDimens()
    }

    @Composable
    fun filterChip(maxWidth: Dp): FilterChipDimens = when {
        maxWidth >= largeTabletMinWidth -> FilterChipDimens(
            textStyle = MyPawDayTypography.robotoRegular16,
            spacing = 12.dp,
            dropdownIconSize = 23.dp,
        )

        maxWidth >= tabletMinWidth -> FilterChipDimens(
            textStyle = MyPawDayTypography.robotoRegular14,
            spacing = 10.dp,
            dropdownIconSize = 21.dp,
        )

        else -> FilterChipDimens()
    }

    @Composable
    fun dialog(screenWidth: Dp): DialogDimens = when {
        screenWidth >= largeTabletMinWidth -> DialogDimens(
            titleStyle = MyPawDayTypography.robotoRegular24,
            buttonStyle = MyPawDayTypography.robotoRegular18,
            horizontalPadding = 56.dp,
            verticalPadding = 64.dp,
            titleButtonSpacing = 32.dp,
            buttonSpacing = 72.dp,
            cornerRadius = 24.dp,
            buttonCornerRadius = 12.dp,
            buttonHorizontalPadding = 28.dp,
            buttonVerticalPadding = 18.dp,
        )

        screenWidth >= tabletMinWidth -> DialogDimens(
            titleStyle = MyPawDayTypography.robotoRegular20,
            buttonStyle = MyPawDayTypography.robotoRegular16,
            horizontalPadding = 48.dp,
            verticalPadding = 56.dp,
            titleButtonSpacing = 28.dp,
            buttonSpacing = 64.dp,
            cornerRadius = 22.dp,
            buttonCornerRadius = 11.dp,
            buttonHorizontalPadding = 24.dp,
            buttonVerticalPadding = 16.dp,
        )

        else -> DialogDimens()
    }
}