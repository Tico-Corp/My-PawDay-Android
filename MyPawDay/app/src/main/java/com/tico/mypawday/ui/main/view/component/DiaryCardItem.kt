package com.tico.mypawday.ui.main.view.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.tico.mypawday.R
import com.tico.mypawday.ui.icons.MyPawDayIcons
import com.tico.mypawday.ui.main.view.model.DiaryCard
import com.tico.mypawday.ui.main.view.model.DiaryType
import com.tico.mypawday.ui.theme.MyPawDayTheme
import com.tico.mypawday.ui.theme.MyPawDayTypography
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import kotlin.math.roundToInt

private enum class DragValue { Settled, RevealedEnd }

private val REVEAL_WIDTH = 57.dp
private val feeFormat = DecimalFormat("#,###")

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DiaryCardItem(
    card: DiaryCard,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val revealWidthPx = with(density) { REVEAL_WIDTH.toPx() }

    val anchors = remember(revealWidthPx) {
        DraggableAnchors {
            DragValue.Settled at 0f
            DragValue.RevealedEnd at -revealWidthPx
        }
    }
    val anchoredState = remember {
        AnchoredDraggableState(
            initialValue = DragValue.Settled,
            anchors = anchors,
        )
    }
    val flingBehavior = AnchoredDraggableDefaults.flingBehavior(
        state = anchoredState,
        positionalThreshold = { it * 0.5f },
        animationSpec = tween(),
    )

    val typeColor = if (card.type == DiaryType.WALK) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MyPawDayTheme.colorScheme.splashyBlue
    }
    val typeLabel = stringResource(
        if (card.type == DiaryType.WALK) R.string.category_walk else R.string.category_hospital,
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
    ) {
        Box(
            modifier = Modifier
                .width(REVEAL_WIDTH)
                .fillMaxHeight()
                .align(Alignment.CenterEnd)
                .background(
                    MaterialTheme.colorScheme.error,
                    RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp),
                )
                .clickable { showDeleteDialog = true },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = MyPawDayIcons.IcDeleteCard,
                contentDescription = stringResource(R.string.content_delete),
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.background,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(anchoredState.offset.roundToInt(), 0) }
                .anchoredDraggable(
                    anchoredState,
                    Orientation.Horizontal,
                    flingBehavior = flingBehavior
                )
                .background(MaterialTheme.colorScheme.surface),
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(typeColor),
            )
            Box(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 13.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        text = typeLabel,
                        style = MyPawDayTypography.robotoRegular12,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier
                            .background(typeColor, RoundedCornerShape(40))
                            .padding(horizontal = 10.dp, vertical = 2.dp),
                    )

                    val timeText = if (card.endTime != null) {
                        "${card.startTime} ~ ${card.endTime}"
                    } else {
                        card.startTime
                    }
                    Text(
                        text = timeText,
                        style = MyPawDayTypography.robotoRegular10,
                        color = MaterialTheme.colorScheme.onSurface,
                    )

                    if (card.type == DiaryType.HOSPITAL && card.fee != null) {
                        Text(
                            text = "${feeFormat.format(card.fee)}원",
                            style = MyPawDayTypography.robotoRegular10,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }

                    if (card.pets.isNotEmpty()) {
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            card.pets.forEach { petName ->
                                Text(
                                    text = petName,
                                    style = MyPawDayTypography.robotoRegular12,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .background(
                                            MaterialTheme.colorScheme.secondaryContainer,
                                            RoundedCornerShape(40),
                                        )
                                        .padding(horizontal = 10.dp, vertical = 2.dp),
                                )
                            }
                        }
                    }

                    Text(
                        text = card.description,
                        style = MyPawDayTypography.robotoRegular12,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                if (card.photoUrl != null) {
                    GlideImage(
                        imageModel = { card.photoUrl },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 10.dp, end = 18.dp)
                            .size(65.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    )
                }
            }
        }
    }

    if (showDeleteDialog) {
        DeleteConfirmDialog(
            onConfirm = {
                showDeleteDialog = false
                onDelete()
            },
            onDismiss = {
                showDeleteDialog = false
                scope.launch {
                    anchoredState.dispatchRawDelta(-anchoredState.offset)
                }
            },
        )
    }
}
