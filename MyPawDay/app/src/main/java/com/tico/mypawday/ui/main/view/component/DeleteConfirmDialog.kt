package com.tico.mypawday.ui.main.view.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tico.mypawday.R
import com.tico.mypawday.ui.component.BaseConfirmDialog

@Composable
fun DeleteConfirmDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    BaseConfirmDialog(
        title = stringResource(R.string.title_delete_confirm),
        cancelText = stringResource(R.string.content_cancel),
        confirmText = stringResource(R.string.content_delete_action),
        onConfirm = onConfirm,
        onDismiss = onDismiss,
    )
}