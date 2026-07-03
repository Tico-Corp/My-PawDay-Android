package com.tico.mypawday.ui.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tico.mypawday.ui.main.view.component.CalendarSection
import com.tico.mypawday.ui.main.view.component.DiaryCardItem
import com.tico.mypawday.ui.main.view.component.ExpandableFab
import com.tico.mypawday.ui.main.view.component.FilterChipsRow
import com.tico.mypawday.ui.main.view.component.MainTopBar
import com.tico.mypawday.ui.main.view.component.PetFilterBottomSheet
import com.tico.mypawday.ui.main.view.model.CalendarDay
import com.tico.mypawday.ui.main.view.model.DiaryCard
import com.tico.mypawday.ui.main.view.model.DiaryType
import com.tico.mypawday.ui.main.view.model.Pet
import com.tico.mypawday.ui.theme.FilterChipDimens
import com.tico.mypawday.ui.theme.MyPawDayDimens
import com.tico.mypawday.ui.theme.MyPawDayTheme
import com.tico.mypawday.ui.theme.TopBarDimens
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onMyPageClick: () -> Unit,
    isCompactHeight: Boolean? = null,
) {
    val today = remember { Clock.System.todayIn(TimeZone.currentSystemDefault()) }

    var currentYear by remember { mutableIntStateOf(today.year) }
    var currentMonth by remember { mutableIntStateOf(today.monthNumber) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(today) }
    var selectedFilters by remember { mutableStateOf(setOf<DiaryType>()) }
    var selectedPetIds by remember { mutableStateOf(setOf<Long>()) }
    var showPetFilter by remember { mutableStateOf(false) }
    var isFabExpanded by remember { mutableStateOf(false) }

    val pets = remember { generateDummyPets() }

    val calendarDays = remember(currentYear, currentMonth) {
        generateCalendarDays(currentYear, currentMonth).applyDummyData(today)
    }

    var diaryCards by remember { mutableStateOf(generateDummyCards()) }

    val filteredCards = remember(diaryCards, selectedFilters, selectedPetIds, pets) {
        filterDiaryCards(
            cards = diaryCards,
            selectedFilters = selectedFilters,
            selectedPetIds = selectedPetIds,
            pets = pets,
        )
    }

    val selectedPets = remember(pets, selectedPetIds) {
        pets.filter { it.id in selectedPetIds }
    }

    val onPreviousMonth: () -> Unit = remember(currentYear, currentMonth) {
        {
            if (currentMonth == 1) {
                currentYear--
                currentMonth = 12
            } else {
                currentMonth--
            }
        }
    }
    val onNextMonth: () -> Unit = remember(currentYear, currentMonth) {
        {
            if (currentMonth == 12) {
                currentYear++
                currentMonth = 1
            } else {
                currentMonth++
            }
        }
    }
    val onTodayClick: () -> Unit = remember(today) {
        {
            currentYear = today.year
            currentMonth = today.monthNumber
            selectedDate = today
        }
    }
    val onDayClick: (CalendarDay) -> Unit = remember {
        { day ->
            if (day.isCurrentMonth) selectedDate = day.date
        }
    }
    val onFilterToggle: (DiaryType) -> Unit = remember {
        { type ->
            selectedFilters = if (type in selectedFilters) {
                selectedFilters - type
            } else {
                selectedFilters + type
            }
        }
    }
    val onPetFilterClick: () -> Unit = remember { { showPetFilter = true } }
    val onDeleteCard: (DiaryCard) -> Unit = remember {
        { card -> diaryCards = diaryCards.filter { it.id != card.id } }
    }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        val compactHeight = isCompactHeight ?: (maxWidth > maxHeight)
        val useLandscapeLayout = compactHeight || maxWidth >= MyPawDayDimens.tabletMinWidth
        val topBarDimens = MyPawDayDimens.topBar(maxWidth)
        val fabDimens = MyPawDayDimens.fab(maxWidth)
        val chipDimens = MyPawDayDimens.filterChip(maxWidth)

        if (useLandscapeLayout) {
            MainScreenLandscape(
                onMyPageClick = onMyPageClick,
                filteredCards = filteredCards,
                calendarDays = calendarDays,
                currentYear = currentYear,
                currentMonth = currentMonth,
                selectedDate = selectedDate,
                today = today,
                selectedFilters = selectedFilters,
                selectedPets = selectedPets,
                onPreviousMonth = onPreviousMonth,
                onNextMonth = onNextMonth,
                onTodayClick = onTodayClick,
                onDayClick = onDayClick,
                onFilterToggle = onFilterToggle,
                onPetFilterClick = onPetFilterClick,
                onDeleteCard = onDeleteCard,
                topBarDimens = topBarDimens,
                chipDimens = chipDimens,
                fillCalendarHeight = compactHeight,
            )
        } else {
            MainScreenPortrait(
                onMyPageClick = onMyPageClick,
                filteredCards = filteredCards,
                calendarDays = calendarDays,
                currentYear = currentYear,
                currentMonth = currentMonth,
                selectedDate = selectedDate,
                today = today,
                selectedFilters = selectedFilters,
                selectedPets = selectedPets,
                onPreviousMonth = onPreviousMonth,
                onNextMonth = onNextMonth,
                onTodayClick = onTodayClick,
                onDayClick = onDayClick,
                onFilterToggle = onFilterToggle,
                onPetFilterClick = onPetFilterClick,
                onDeleteCard = onDeleteCard,
                topBarDimens = topBarDimens,
                chipDimens = chipDimens,
            )
        }

        if (showPetFilter) {
            PetFilterBottomSheet(
                pets = pets,
                selectedPetIds = selectedPetIds,
                onApply = { ids ->
                    selectedPetIds = ids
                    showPetFilter = false
                },
                onDismiss = { showPetFilter = false },
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

@Composable
private fun MainScreenPortrait(
    onMyPageClick: () -> Unit,
    filteredCards: List<DiaryCard>,
    calendarDays: List<CalendarDay>,
    currentYear: Int,
    currentMonth: Int,
    selectedDate: LocalDate?,
    today: LocalDate,
    selectedFilters: Set<DiaryType>,
    selectedPets: List<Pet>,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onTodayClick: () -> Unit,
    onDayClick: (CalendarDay) -> Unit,
    onFilterToggle: (DiaryType) -> Unit,
    onPetFilterClick: () -> Unit,
    onDeleteCard: (DiaryCard) -> Unit,
    topBarDimens: TopBarDimens = TopBarDimens(),
    chipDimens: FilterChipDimens = FilterChipDimens(),
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 18.dp,
            end = 18.dp,
            top = 48.dp,
            bottom = 80.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            MainTopBar(
                onMyPageClick = onMyPageClick,
                myPageIconSize = topBarDimens.myPageIconSize,
                logoHeight = topBarDimens.logoHeight,
            )
        }

        item {
            FilterChipsRow(
                selectedFilters = selectedFilters,
                onFilterToggle = onFilterToggle,
                dimens = chipDimens,
                onPetFilterClick = onPetFilterClick,
                selectedPets = selectedPets,
            )
        }

        item {
            CalendarSection(
                year = currentYear,
                month = currentMonth,
                days = calendarDays,
                selectedDate = selectedDate,
                today = today,
                onPreviousMonth = onPreviousMonth,
                onNextMonth = onNextMonth,
                onTodayClick = onTodayClick,
                onDayClick = onDayClick,
            )
        }

        items(
            items = filteredCards,
            key = { it.id },
        ) { card ->
            DiaryCardItem(
                card = card,
                onDelete = { onDeleteCard(card) },
            )
        }
    }
}

@Composable
private fun MainScreenLandscape(
    onMyPageClick: () -> Unit,
    filteredCards: List<DiaryCard>,
    calendarDays: List<CalendarDay>,
    currentYear: Int,
    currentMonth: Int,
    selectedDate: LocalDate?,
    today: LocalDate,
    selectedFilters: Set<DiaryType>,
    selectedPets: List<Pet>,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onTodayClick: () -> Unit,
    onDayClick: (CalendarDay) -> Unit,
    onFilterToggle: (DiaryType) -> Unit,
    onPetFilterClick: () -> Unit,
    onDeleteCard: (DiaryCard) -> Unit,
    topBarDimens: TopBarDimens = TopBarDimens(),
    chipDimens: FilterChipDimens = FilterChipDimens(),
    fillCalendarHeight: Boolean = false,
) {
    var splitRatio by remember { mutableFloatStateOf(0.48f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        MainTopBar(
            onMyPageClick = onMyPageClick,
            myPageIconSize = topBarDimens.myPageIconSize,
            logoHeight = topBarDimens.logoHeight,
        )

        Spacer(modifier = Modifier.height(8.dp))

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            val density = LocalDensity.current
            val totalWidthPx = with(density) { maxWidth.toPx() }

            Row(modifier = Modifier.fillMaxSize()) {
                BoxWithConstraints(
                    modifier = Modifier
                        .weight(splitRatio)
                        .fillMaxHeight()
                ) {
                    val calendarScrollState = rememberScrollState()
                    val calendarCellSize: Dp? = if (fillCalendarHeight) {
                        val weekCount = calendarDays.chunked(7)
                            .count { week -> week.any { it.isCurrentMonth } }
                            .coerceAtLeast(1)
                        val reserved = 40 + (weekCount + 1) * 4
                        val cellByWidth = maxWidth / 7
                        val cellByHeight = (maxHeight - reserved.dp) / weekCount
                        val cellSize = if (cellByWidth < cellByHeight) cellByWidth else cellByHeight
                        cellSize.coerceAtLeast(12.dp)
                    } else null

                    Column(
                        modifier = if (fillCalendarHeight) {
                            Modifier.fillMaxHeight()
                        } else {
                            Modifier.verticalScroll(calendarScrollState)
                        },
                    ) {
                        CalendarSection(
                            year = currentYear,
                            month = currentMonth,
                            days = calendarDays,
                            selectedDate = selectedDate,
                            today = today,
                            onPreviousMonth = onPreviousMonth,
                            onNextMonth = onNextMonth,
                            onTodayClick = onTodayClick,
                            onDayClick = onDayClick,
                            modifier = if (fillCalendarHeight) Modifier.weight(1f) else Modifier,
                            cellSize = calendarCellSize,
                        )
                    }
                }

                SplitDragHandle(
                    onDrag = { delta ->
                        splitRatio = (splitRatio + delta / totalWidthPx)
                            .coerceIn(0.3f, 0.7f)
                    },
                )

                Column(
                    modifier = Modifier
                        .weight(1f - splitRatio)
                        .fillMaxHeight(),
                ) {
                    FilterChipsRow(
                        selectedFilters = selectedFilters,
                        onFilterToggle = onFilterToggle,
                        dimens = chipDimens,
                        onPetFilterClick = onPetFilterClick,
                        selectedPets = selectedPets,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(
                            items = filteredCards,
                            key = { it.id },
                        ) { card ->
                            DiaryCardItem(
                                card = card,
                                onDelete = { onDeleteCard(card) },
                            )
                        }

                        item { Spacer(modifier = Modifier.height(80.dp)) }
                    }
                }
            }
        }
    }
}

private fun filterDiaryCards(
    cards: List<DiaryCard>,
    selectedFilters: Set<DiaryType>,
    selectedPetIds: Set<Long>,
    pets: List<Pet>,
): List<DiaryCard> {
    val selectedPetNames = pets
        .filter { it.id in selectedPetIds }
        .map { it.name }
        .toSet()

    return cards.filter { card ->
        val matchesType = selectedFilters.isEmpty() || card.type in selectedFilters
        val matchesPet = selectedPetNames.isEmpty() || card.pets.any { it in selectedPetNames }

        matchesType && matchesPet
    }
}

@Composable
private fun SplitDragHandle(
    onDrag: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(20.dp)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState(onDelta = onDrag),
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            repeat(3) {
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .background(MaterialTheme.colorScheme.outlineVariant, CircleShape),
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun MainScreenLightDarkPreview() {
    MyPawDayTheme {
        MainScreen(onMyPageClick = {})
    }
}
