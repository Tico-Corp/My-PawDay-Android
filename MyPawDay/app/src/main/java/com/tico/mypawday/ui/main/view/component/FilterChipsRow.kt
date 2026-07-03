package com.tico.mypawday.ui.main.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tico.mypawday.R
import com.tico.mypawday.ui.icons.MyPawDayIcons
import com.tico.mypawday.ui.main.view.model.DiaryType
import com.tico.mypawday.ui.main.view.model.Pet
import com.tico.mypawday.ui.theme.FilterChipDimens

private val PET_CHIP_IMAGE_SIZE = 20.dp
private val PET_CHIP_OVERLAP_OFFSET = 14.dp

@Composable
fun FilterChipsRow(
    selectedFilters: Set<DiaryType>,
    onFilterToggle: (DiaryType) -> Unit,
    dimens: FilterChipDimens,
    modifier: Modifier = Modifier,
    onPetFilterClick: () -> Unit = {},
    selectedPets: List<Pet> = emptyList(),
) {
    val chipShape = CircleShape
    val chipContentPadding = PaddingValues(
        horizontal = dimens.horizontalPadding,
        vertical = dimens.verticalPadding,
    )
    val borderColor = MaterialTheme.colorScheme.primaryContainer
    val containerColor = MaterialTheme.colorScheme.background
    val selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer

    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimens.spacing),
        verticalArrangement = Arrangement.spacedBy(dimens.spacing),
        itemVerticalAlignment = Alignment.CenterVertically
    ) {
        PetFilterChip(
            selectedPets = selectedPets,
            onClick = onPetFilterClick,
            dimens = dimens,
            chipShape = chipShape,
            borderColor = borderColor,
            containerColor = containerColor,
            selectedContainerColor = selectedContainerColor,
            chipContentPadding = chipContentPadding,
        )

        DiaryType.entries.forEach { type ->
            DiaryTypeFilterChip(
                type = type,
                selected = type in selectedFilters,
                onClick = { onFilterToggle(type) },
                dimens = dimens,
                chipShape = chipShape,
                borderColor = borderColor,
                containerColor = containerColor,
                selectedContainerColor = selectedContainerColor,
                chipContentPadding = chipContentPadding,
            )
        }
    }
}

@Composable
private fun PetFilterChip(
    selectedPets: List<Pet>,
    onClick: () -> Unit,
    dimens: FilterChipDimens,
    chipShape: Shape,
    borderColor: Color,
    containerColor: Color,
    selectedContainerColor: Color,
    chipContentPadding: PaddingValues,
) {
    val selected = selectedPets.isNotEmpty()
    FilterChip(
        contentPadding = chipContentPadding,
        onClick = onClick,
        selected = selected,
        label = {
            PetFilterChipLabel(
                selectedPets = selectedPets,
                dimens = dimens,
            )
        },
        trailingIcon = {
            Icon(
                imageVector = MyPawDayIcons.IcArrowDropDown,
                contentDescription = null,
                modifier = Modifier.size(dimens.dropdownIconSize),
            )
        },
        shape = chipShape,
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = selected,
            borderColor = borderColor,
            selectedBorderColor = borderColor,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = containerColor,
            selectedContainerColor = selectedContainerColor,
        ),
    )
}

@Composable
private fun PetFilterChipLabel(
    selectedPets: List<Pet>,
    dimens: FilterChipDimens,
) {
    if (selectedPets.isEmpty()) {
        Text(
            text = stringResource(R.string.category_pet),
            style = dimens.textStyle,
            color = MaterialTheme.colorScheme.onBackground,
        )
        return
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OverlappingPetImages(
            pets = selectedPets,
            imageSize = PET_CHIP_IMAGE_SIZE,
            overlapOffset = PET_CHIP_OVERLAP_OFFSET,
        )

        if (selectedPets.size > 3) {
            Text(
                text = stringResource(R.string.content_ellipsis),
                style = dimens.textStyle,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}

@Composable
private fun DiaryTypeFilterChip(
    type: DiaryType,
    selected: Boolean,
    onClick: () -> Unit,
    dimens: FilterChipDimens,
    chipShape: Shape,
    borderColor: Color,
    containerColor: Color,
    selectedContainerColor: Color,
    chipContentPadding: PaddingValues,
) {
    val label = stringResource(
        when (type) {
            DiaryType.WALK -> R.string.category_walk
            DiaryType.HOSPITAL -> R.string.category_hospital
        },
    )
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = {
            Text(
                label,
                style = dimens.textStyle,
                color = MaterialTheme.colorScheme.onBackground,
            )
        },
        shape = chipShape,
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = selected,
            borderColor = borderColor,
            selectedBorderColor = borderColor,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = containerColor,
            selectedContainerColor = selectedContainerColor,
        ),
        contentPadding = chipContentPadding,
    )
}