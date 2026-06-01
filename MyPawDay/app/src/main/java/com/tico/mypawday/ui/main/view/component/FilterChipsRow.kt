package com.tico.mypawday.ui.main.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.tico.mypawday.R
import com.tico.mypawday.ui.icons.MyPawDayIcons
import com.tico.mypawday.ui.main.view.model.DiaryType
import com.tico.mypawday.ui.theme.FilterChipDimens

@Composable
fun FilterChipsRow(
    selectedFilters: Set<DiaryType>,
    onFilterToggle: (DiaryType) -> Unit,
    dimens: FilterChipDimens,
    modifier: Modifier = Modifier,
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
    ) {
        InputChip(
            selected = false,
            onClick = { /* TODO: 펫 필터 바텀시트 */ },
            label = {
                Text(
                    stringResource(R.string.category_pet),
                    style = dimens.textStyle,
                    color = MaterialTheme.colorScheme.onBackground,
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
            border = InputChipDefaults.inputChipBorder(
                enabled = true,
                selected = false,
                borderColor = borderColor,
                selectedBorderColor = borderColor,
            ),
            colors = InputChipDefaults.inputChipColors(
                containerColor = containerColor,
                selectedContainerColor = selectedContainerColor,
            ),
            contentPadding = chipContentPadding,
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