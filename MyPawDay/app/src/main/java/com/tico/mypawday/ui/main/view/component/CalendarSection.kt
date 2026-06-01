package com.tico.mypawday.ui.main.view.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tico.mypawday.R
import com.tico.mypawday.ui.icons.MyPawDayIcons
import com.tico.mypawday.ui.main.view.model.CalendarDay
import com.tico.mypawday.ui.theme.MyPawDayTypography
import kotlinx.datetime.LocalDate

@Composable
fun CalendarSection(
    year: Int,
    month: Int,
    days: List<CalendarDay>,
    selectedDate: LocalDate?,
    today: LocalDate,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onTodayClick: () -> Unit,
    onDayClick: (CalendarDay) -> Unit,
    modifier: Modifier = Modifier,
    cellSize: Dp? = null,
) {
    val headerSpacing = if (cellSize != null) 10.dp else 5.dp

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(headerSpacing),
    ) {
        CalendarHeader(
            year = year,
            month = month,
            today = today,
            onPreviousMonth = onPreviousMonth,
            onNextMonth = onNextMonth,
            onTodayClick = onTodayClick,
        )

        // 요일 행 + 날짜 그리드를 하나로 묶어 사이 공백 제거
        // 가로 모드(cellSize != null): weight(1f)로 bounded height 확보
        // 세로 모드(cellSize == null): weight 없이 content 크기만큼 wrap
        Column(
            modifier = if (cellSize != null) {
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            } else {
                Modifier.fillMaxWidth()
            },
        ) {
            WeekdayRow()
            CalendarGrid(
                days = days,
                selectedDate = selectedDate,
                today = today,
                onDayClick = onDayClick,
                cellSize = cellSize,
                modifier = if (cellSize != null) {
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                } else {
                    Modifier.fillMaxWidth()
                },
            )
        }
    }
}

@Composable
private fun CalendarGrid(
    days: List<CalendarDay>,
    selectedDate: LocalDate?,
    today: LocalDate,
    onDayClick: (CalendarDay) -> Unit,
    cellSize: Dp?,
    modifier: Modifier = Modifier,
) {
    val weeks = days.chunked(7).filter { week -> week.any { it.isCurrentMonth } }

    Column(
        modifier = modifier,
        verticalArrangement = if (cellSize != null) Arrangement.SpaceBetween else Arrangement.spacedBy(
            4.dp
        ),
    ) {
        weeks.forEach { week ->
            WeekRow(
                week = week,
                selectedDate = selectedDate,
                today = today,
                onDayClick = onDayClick,
                cellSize = cellSize,
            )
        }
        if (cellSize != null) {
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}

@Composable
private fun WeekRow(
    week: List<CalendarDay>,
    selectedDate: LocalDate?,
    today: LocalDate,
    onDayClick: (CalendarDay) -> Unit,
    cellSize: Dp?,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        val cellModifier = if (cellSize != null) {
            Modifier.size(cellSize)
        } else {
            Modifier
                .weight(1f)
                .aspectRatio(1f)
        }
        week.forEach { day ->
            if (day.isCurrentMonth) {
                CalendarDayCell(
                    day = day,
                    isSelected = day.date == selectedDate,
                    isToday = day.date == today,
                    onClick = { onDayClick(day) },
                    modifier = cellModifier,
                )
            } else {
                Spacer(modifier = cellModifier)
            }
        }
        repeat(7 - week.size) {
            Spacer(modifier = cellModifier)
        }
    }
}

@Composable
private fun CalendarHeader(
    year: Int,
    month: Int,
    today: LocalDate,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onTodayClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "%d년 %02d월".format(year, month),
            style = MyPawDayTypography.robotoBold12,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onPreviousMonth,
            modifier = Modifier.size(24.dp),
        ) {
            Icon(
                imageVector = MyPawDayIcons.IcKeyboardArrowLeft,
                contentDescription = stringResource(R.string.content_previous_month),
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }

        IconButton(
            onClick = onNextMonth,
            modifier = Modifier.size(24.dp),
        ) {
            Icon(
                imageVector = MyPawDayIcons.IcKeyboardArrowRight,
                contentDescription = stringResource(R.string.content_next_month),
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }

        Box(
            modifier = Modifier
                .size(24.dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(5.dp),
                )
                .clickable(onClick = onTodayClick),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "${today.dayOfMonth}",
                style = MyPawDayTypography.robotoBold10,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun WeekdayRow() {
    val weekdayLabels = listOf(
        stringResource(R.string.category_sunday),
        stringResource(R.string.category_monday),
        stringResource(R.string.category_tuesday),
        stringResource(R.string.category_wednesday),
        stringResource(R.string.category_thursday),
        stringResource(R.string.category_friday),
        stringResource(R.string.category_saturday),
    )

    Row(modifier = Modifier.fillMaxWidth()) {
        weekdayLabels.forEach { label ->
            Text(
                text = label,
                style = MyPawDayTypography.robotoBold12,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
