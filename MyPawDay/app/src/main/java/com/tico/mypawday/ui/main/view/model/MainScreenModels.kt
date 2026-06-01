package com.tico.mypawday.ui.main.view.model

import kotlinx.datetime.LocalDate

enum class PetCondition {
    GOOD, NORMAL, BAD
}

enum class DiaryType {
    WALK, HOSPITAL
}

data class Pet(
    val id: Long,
    val name: String,
)

data class CalendarDay(
    val date: LocalDate,
    val isCurrentMonth: Boolean,
    val condition: PetCondition? = null,
    val hasHospital: Boolean = false,
    val petImageRes: Int? = null,
)

data class DiaryCard(
    val id: Long,
    val type: DiaryType,
    val startTime: String,
    val endTime: String? = null,
    val fee: String? = null,
    val pets: List<String>,
    val description: String,
    val photoRes: Int? = null,
)