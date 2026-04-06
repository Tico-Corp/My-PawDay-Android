package com.tico.mypawday.ui.main.view.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tico.mypawday.R
import com.tico.mypawday.ui.icons.MyPawDayIcons

@Composable
fun ExpandableFab(
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onWalkClick: () -> Unit,
    onHospitalClick: () -> Unit,
    modifier: Modifier = Modifier,
    mainFabSize: Dp,
    subFabSize: Dp,
    mainIconSize: Dp,
    subIconSize: Dp,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        AnimatedVisibility(
            visible = isExpanded,
            enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                FloatingActionButton(
                    onClick = onWalkClick,
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.size(subFabSize),
                ) {
                    Icon(
                        imageVector = MyPawDayIcons.IcAddWalk,
                        contentDescription = stringResource(R.string.content_add_walk),
                        modifier = Modifier.size(subIconSize),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }

                FloatingActionButton(
                    onClick = onHospitalClick,
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.size(subFabSize),
                ) {
                    Icon(
                        imageVector = MyPawDayIcons.IcAddHospital,
                        contentDescription = stringResource(R.string.content_add_hospital),
                        modifier = Modifier.size(subIconSize),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = onToggle,
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier.size(mainFabSize),
        ) {
            Icon(
                imageVector = if (isExpanded) {
                    MyPawDayIcons.IcToggleClose
                } else {
                    MyPawDayIcons.IcToggleAdd
                },
                contentDescription = if (isExpanded) {
                    stringResource(R.string.content_fab_close)
                } else {
                    stringResource(R.string.content_fab_add)
                },
                modifier = Modifier.size(mainIconSize),
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}
