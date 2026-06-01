package com.tico.mypawday.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tico.mypawday.ui.theme.MyPawDayDimens

@Composable
fun BaseConfirmDialog(
    title: String,
    cancelText: String,
    confirmText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val dimens = MyPawDayDimens.dialog(screenWidth)

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(dimens.cornerRadius))
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = dimens.horizontalPadding, vertical = dimens.verticalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimens.titleButtonSpacing),
        ) {
            Text(
                text = title,
                style = dimens.titleStyle,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(dimens.buttonSpacing),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = cancelText,
                    style = dimens.buttonStyle,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimens.buttonCornerRadius))
                        .clickable(onClick = onDismiss)
                        .padding(
                            horizontal = dimens.buttonHorizontalPadding,
                            vertical = dimens.buttonVerticalPadding,
                        ),
                )

                Text(
                    text = confirmText,
                    style = dimens.buttonStyle,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimens.buttonCornerRadius))
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            RoundedCornerShape(dimens.buttonCornerRadius),
                        )
                        .clickable(onClick = onConfirm)
                        .padding(
                            horizontal = dimens.buttonHorizontalPadding,
                            vertical = dimens.buttonVerticalPadding,
                        ),
                )
            }
        }
    }
}
