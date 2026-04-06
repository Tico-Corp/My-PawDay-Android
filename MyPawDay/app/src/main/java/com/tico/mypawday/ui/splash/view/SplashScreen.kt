package com.tico.mypawday.ui.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.tico.mypawday.R
import com.tico.mypawday.ui.theme.MyPawDayDimens
import com.tico.mypawday.ui.theme.MyPawDayTheme

@Composable
fun SplashScreen(
    isCompactHeight: Boolean? = null,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MyPawDayTheme.colorScheme.yellowish),
        contentAlignment = Alignment.Center,
    ) {
        val compactHeight = isCompactHeight ?: (maxHeight < 480.dp)
        val splashDimens = MyPawDayDimens.splash(maxWidth)

        val imageModifier = if (compactHeight) {
            Modifier.fillMaxHeight(splashDimens.logoHeightFraction)
        } else {
            Modifier.fillMaxWidth(splashDimens.logoWidthFraction)
        }

        Image(
            painter = painterResource(R.drawable.ic_banner_vertical),
            contentDescription = stringResource(R.string.content_ic_logo),
            modifier = imageModifier,
            contentScale = if (compactHeight) ContentScale.Fit else ContentScale.FillWidth,
        )
    }
}

@PreviewLightDark
@Composable
private fun SplashScreenPreview() {
    MyPawDayTheme {
        SplashScreen()
    }
}