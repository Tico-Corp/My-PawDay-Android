package com.tico.mypawday.ui.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.tico.mypawday.ui.main.view.component.ExpandableFab
import com.tico.mypawday.ui.main.view.component.FilterChipsRow
import com.tico.mypawday.ui.main.view.component.MainTopBar
import com.tico.mypawday.ui.main.view.model.DiaryType
import com.tico.mypawday.ui.theme.MyPawDayDimens
import com.tico.mypawday.ui.theme.MyPawDayTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onMyPageClick: () -> Unit,
    isCompactHeight: Boolean? = null,
) {
    var selectedFilters by remember { mutableStateOf(setOf<DiaryType>()) }
    var isFabExpanded by remember { mutableStateOf(false) }

    val onFilterToggle: (DiaryType) -> Unit = remember {
        { type ->
            selectedFilters = if (type in selectedFilters) {
                selectedFilters - type
            } else {
                selectedFilters + type
            }
        }
    }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        val topBarDimens = MyPawDayDimens.topBar(maxWidth)
        val fabDimens = MyPawDayDimens.fab(maxWidth)
        val chipDimens = MyPawDayDimens.filterChip(maxWidth)
        val contentPadding = MyPawDayDimens.contentPadding(maxWidth)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = contentPadding.contentVerticalPadding,
                    horizontal = contentPadding.contentHorizontalPadding
                ),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            MainTopBar(
                onMyPageClick = onMyPageClick,
                myPageIconSize = topBarDimens.myPageIconSize,
                logoHeight = topBarDimens.logoHeight,
            )

            FilterChipsRow(
                selectedFilters = selectedFilters,
                onFilterToggle = onFilterToggle,
                dimens = chipDimens,
            )
        }

        ExpandableFab(
            isExpanded = isFabExpanded,
            onToggle = { isFabExpanded = !isFabExpanded },
            onWalkClick = { /* TODO: 산책 추가 화면 */ },
            onHospitalClick = { /* TODO: 병원 추가 화면 */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 24.dp),
            mainFabSize = fabDimens.mainFabSize,
            subFabSize = fabDimens.subFabSize,
            mainIconSize = fabDimens.mainIconSize,
            subIconSize = fabDimens.subIconSize,
        )
    }
}

@PreviewLightDark
@Composable
fun MainScreenLightDarkPreview() {
    MyPawDayTheme {
        MainScreen(onMyPageClick = {})
    }
}