package com.tico.mypawday.ui.main.view

import com.tico.mypawday.ui.main.view.model.CalendarDay
import com.tico.mypawday.ui.main.view.model.PetCondition
import kotlinx.datetime.LocalDate

internal fun List<CalendarDay>.applyDummyData(today: LocalDate): List<CalendarDay> = map { day ->
    if (!day.isCurrentMonth) {
        day
    } else {
        day.copy(
            condition = getDummyCondition(day.date, today),
            hasHospital = isDummyHospitalDay(day.date, today),
        )
    }
}

internal fun getDummyCondition(date: LocalDate, today: LocalDate): PetCondition? {
    if (date > today) return null
    return when (date.dayOfMonth % 5) {
        0 -> PetCondition.GOOD
        1 -> PetCondition.NORMAL
        2 -> PetCondition.BAD
        else -> null
    }
}

internal fun isDummyHospitalDay(date: LocalDate, today: LocalDate): Boolean {
    if (date > today) return false
    return date.dayOfMonth % 10 == 3
}

