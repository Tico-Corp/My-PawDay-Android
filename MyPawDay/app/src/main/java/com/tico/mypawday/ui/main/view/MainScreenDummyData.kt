package com.tico.mypawday.ui.main.view

import com.tico.mypawday.ui.main.view.model.CalendarDay
import com.tico.mypawday.ui.main.view.model.DiaryCard
import com.tico.mypawday.ui.main.view.model.DiaryType
import com.tico.mypawday.ui.main.view.model.Pet
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

internal fun generateDummyPets(): List<Pet> = listOf(
    Pet(id = 1, name = "뽀삐"),
    Pet(id = 2, name = "코코"),
    Pet(id = 3, name = "차돌"),
    Pet(id = 4, name = "초코"),
    Pet(id = 5, name = "모카"),
    Pet(id = 6, name = "커피"),
)

internal fun generateDummyCards(): List<DiaryCard> = listOf(
    DiaryCard(
        id = 1,
        type = DiaryType.WALK,
        startTime = "09:00",
        endTime = "09:45",
        pets = listOf("뽀삐", "코코"),
        description = "오늘 아침 산책은 공원에서 했어요. 날씨가 좋아서 기분 좋게 산책했습니다.오늘 아침 산책은 공원에서 했어요. 날씨가 좋아서 기분 좋게 산책했습니다.오늘 아침 산책은 공원에서 했어요. 날씨가 좋아서 기분 좋게 산책했습니다.오늘 아침 산책은 공원에서 했어요. 날씨가 좋아서 기분 좋게 산책했습니다.",
        photoUrl = null,
    ),
    DiaryCard(
        id = 2,
        type = DiaryType.HOSPITAL,
        startTime = "14:00",
        fee = 35000L,
        pets = listOf("뽀삐"),
        description = "정기 건강검진을 받았어요. 모든 수치가 정상이래요!",
    ),
    DiaryCard(
        id = 3,
        type = DiaryType.WALK,
        startTime = "18:30",
        endTime = "19:00",
        pets = listOf("코코"),
        description = "저녁 산책. 다른 강아지 친구들을 만나서 신나게 놀았어요.",
    ),
    DiaryCard(
        id = 4,
        type = DiaryType.HOSPITAL,
        startTime = "10:00",
        fee = 15000L,
        pets = listOf("코코", "뽀삐"),
        description = "예방접종 맞으러 갔다왔어요.",
    ),
)