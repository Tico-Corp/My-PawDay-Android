package com.tico.mypawday.ui.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.tico.mypawday.R
import com.tico.mypawday.ui.theme.MyPawDayTheme

@Composable
fun LoginScreen(
    onKakaoLoginClick: () -> Unit,
    isCompactHeight: Boolean? = null,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        val compactHeight = isCompactHeight ?: (maxHeight < 480.dp)

        val contentWidthFraction = when {
            maxWidth >= 840.dp -> 0.5f
            maxWidth >= 600.dp -> 0.65f
            else -> 1f
        }

        if (compactHeight) {
            LoginScreenLandscape(
                onKakaoLoginClick = onKakaoLoginClick,
            )
        } else {
            LoginScreenPortrait(
                onKakaoLoginClick = onKakaoLoginClick,
                contentWidthFraction = contentWidthFraction,
            )
        }
    }
}

@Composable
private fun LoginScreenPortrait(
    onKakaoLoginClick: () -> Unit,
    contentWidthFraction: Float,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(contentWidthFraction)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(R.drawable.ic_banner_vertical),
                contentDescription = stringResource(R.string.content_ic_logo),
                modifier = Modifier.fillMaxWidth(0.65f),
                contentScale = ContentScale.FillWidth,
            )

            Spacer(modifier = Modifier.weight(0.15f))

            Image(
                painter = painterResource(R.drawable.ic_kakao_login),
                contentDescription = stringResource(R.string.content_kakao_login),
                modifier = Modifier
                    .fillMaxWidth(0.87f)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(role = Role.Button, onClick = onKakaoLoginClick),
                contentScale = ContentScale.FillWidth,
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun LoginScreenLandscape(onKakaoLoginClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_banner_vertical),
                contentDescription = stringResource(R.string.content_ic_logo),
                modifier = Modifier.fillMaxHeight(0.7f),
                contentScale = ContentScale.Fit,
            )
        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_kakao_login),
                contentDescription = stringResource(R.string.content_kakao_login),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(role = Role.Button, onClick = onKakaoLoginClick),
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun LoginScreenPreview() {
    MyPawDayTheme {
        LoginScreen(onKakaoLoginClick = {})
    }
}