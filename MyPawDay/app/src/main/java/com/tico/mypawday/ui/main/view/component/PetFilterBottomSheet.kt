package com.tico.mypawday.ui.main.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.tico.mypawday.R
import com.tico.mypawday.ui.main.view.model.Pet
import com.tico.mypawday.ui.theme.MyPawDayDimens
import com.tico.mypawday.ui.theme.PetFilterSheetDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetFilterBottomSheet(
    pets: List<Pet>,
    selectedPetIds: Set<Long>,
    onApply: (Set<Long>) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var pendingSelectedIds by remember(selectedPetIds) { mutableStateOf(selectedPetIds) }
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        BoxWithConstraints {
            val dimens = MyPawDayDimens.petFilterSheet(maxWidth)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimens.contentHorizontalPadding,
                        vertical = dimens.contentVerticalPadding,
                    ),
                verticalArrangement = Arrangement.spacedBy(dimens.contentVerticalPadding),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
                    contentPadding = PaddingValues(horizontal = 0.dp),
                ) {
                    items(pets, key = { it.id }) { pet ->
                        PetProfileItem(
                            pet = pet,
                            isSelected = pet.id in pendingSelectedIds,
                            onClick = {
                                pendingSelectedIds = if (pet.id in pendingSelectedIds) {
                                    pendingSelectedIds - pet.id
                                } else {
                                    pendingSelectedIds + pet.id
                                }
                            },
                            dimens = dimens,
                        )
                    }
                }

                Button(
                    onClick = { onApply(pendingSelectedIds) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimens.buttonHeight),
                    shape = RoundedCornerShape(dimens.buttonCornerRadius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                ) {
                    Text(
                        text = stringResource(R.string.btn_apply),
                        style = dimens.petNameStyle,
                    )
                }
            }
        }
    }
}

@Composable
private fun PetProfileItem(
    pet: Pet,
    isSelected: Boolean,
    onClick: () -> Unit,
    dimens: PetFilterSheetDimens,
) {
    Column(
        modifier = Modifier
            .width(dimens.petItemWidth)
            .clip(RoundedCornerShape(dimens.itemCornerRadius))
            .background(
                color = if (isSelected) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    Color.Transparent
                },
            )
            .clickable(onClick = onClick)
            .padding(vertical = dimens.itemVerticalPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.itemContentSpacing),
    ) {
        PetProfileImage(
            imageUrl = pet.imageUrl,
            size = dimens.profileImageSize,
        )

        Text(
            text = pet.name,
            style = dimens.petNameStyle,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
internal fun OverlappingPetImages(
    pets: List<Pet>,
    imageSize: Dp,
    overlapOffset: Dp,
    borderColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    shape: Shape = CircleShape,
) {
    val displayPets = pets.take(3)
    Layout(
        content = {
            displayPets.forEach { pet ->
                PetProfileImage(
                    imageUrl = pet.imageUrl,
                    size = imageSize,
                    borderColor = borderColor,
                    shape = shape,
                )
            }
        },
    ) { measurables, _ ->
        val imagePx = imageSize.roundToPx()
        val overlapPx = overlapOffset.roundToPx()
        val placeables = measurables.map {
            it.measure(Constraints.fixed(imagePx, imagePx))
        }
        val n = placeables.size
        val totalWidth = if (n == 0) 0 else imagePx + (n - 1) * overlapPx
        layout(totalWidth, imagePx) {
            placeables.forEachIndexed { index, placeable ->
                placeable.placeRelative(x = index * overlapPx, y = 0)
            }
        }
    }
}

@Composable
private fun PetProfileImage(
    imageUrl: String?,
    size: Dp,
    modifier: Modifier = Modifier,
    borderColor: Color? = null,
    shape: Shape = CircleShape,
) {
    val baseModifier = modifier
        .size(size)
        .clip(shape)
    val imageModifier = baseModifier.withOptionalBorder(
        borderColor = borderColor,
        shape = shape,
    )

    GlideImage(
        imageModel = { imageUrl },
        modifier = imageModifier,
        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
        failure = {
            Box(
                modifier = baseModifier
                    .background(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = shape,
                    )
                    .withOptionalBorder(
                        borderColor = borderColor,
                        shape = shape,
                    ),
            )
        },
    )
}

private fun Modifier.withOptionalBorder(
    borderColor: Color?,
    shape: Shape,
): Modifier {
    return if (borderColor == null) {
        this
    } else {
        border(width = 1.dp, color = borderColor, shape = shape)
    }
}