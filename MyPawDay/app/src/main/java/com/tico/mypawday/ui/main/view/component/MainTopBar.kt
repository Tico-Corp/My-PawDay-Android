package com.tico.mypawday.ui.main.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import com.tico.mypawday.R

@Composable
fun MainTopBar(
    onMyPageClick: () -> Unit,
    modifier: Modifier = Modifier,
    myPageIconSize: Dp,
    logoHeight: Dp,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_banner_horizontal),
            contentDescription = stringResource(R.string.content_ic_logo_vertical),
            modifier = Modifier.height(logoHeight),
            contentScale = ContentScale.Fit,
        )

        Image(
            painter = painterResource(R.drawable.ic_mypage),
            contentDescription = stringResource(R.string.content_ic_mypage),
            modifier = Modifier
                .size(myPageIconSize)
                .clip(CircleShape)
                .clickable(role = Role.Button, onClick = onMyPageClick),
            contentScale = ContentScale.Fit,
        )
    }
}