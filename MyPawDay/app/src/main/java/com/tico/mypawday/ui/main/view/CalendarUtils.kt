package com.tico.mypawday.ui.main.view

import com.tico.mypawday.ui.main.view.model.CalendarDay
import kotlinx.datetime.LocalDate

internal fun generateCalendarDays(
    year: Int,
    month: Int,
): List<CalendarDay> {
    val firstDayOfMonth = LocalDate(year, month, 1)

    val epochDays = firstDayOfMonth.toEpochDays()
    val startDayOfWeek = ((epochDays % 7).toInt() + 4 + 7) % 7

    val daysInMonth = daysInMonth(year, month)
    val days = mutableListOf<CalendarDay>()

    if (startDayOfWeek > 0) {
        val prevMonth = if (month == 1) 12 else month - 1
        val prevYear = if (month == 1) year - 1 else year
        val prevDaysInMonth = daysInMonth(prevYear, prevMonth)
        for (day in (prevDaysInMonth - startDayOfWeek + 1)..prevDaysInMonth) {
            days.add(
                CalendarDay(
                    date = LocalDate(prevYear, prevMonth, day),
                    isCurrentMonth = false,
                ),
            )
        }
    }

    for (day in 1..daysInMonth) {
        days.add(
            CalendarDay(
                date = LocalDate(year, month, day),
                isCurrentMonth = true,
            ),
        )
    }

    val nextMonth = if (month == 12) 1 else month + 1
    val nextYear = if (month == 12) year + 1 else year
    val remaining = 42 - days.size
    for (day in 1..remaining) {
        days.add(
            CalendarDay(
                date = LocalDate(nextYear, nextMonth, day),
                isCurrentMonth = false,
            ),
        )
    }

    return days
}

private fun daysInMonth(year: Int, month: Int): Int = when (month) {
    1, 3, 5, 7, 8, 10, 12 -> 31
    4, 6, 9, 11 -> 30
    2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
    else -> 30
}
