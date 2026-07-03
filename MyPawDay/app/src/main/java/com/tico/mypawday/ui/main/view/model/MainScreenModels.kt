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
    val imageUrl: String? = null,
)

data class CalendarDay(
    val date: LocalDate,
    val isCurrentMonth: Boolean,
    val condition: PetCondition? = null,
    val hasHospital: Boolean = false,
    val petImageUrl: String? = null,
)

data class DiaryCard(
    val id: Long,
    val type: DiaryType,
    val startTime: String,
    val endTime: String? = null,
    val fee: Long? = null,
    val pets: List<String>,
    val description: String,
    val photoUrl: String? = null,
)