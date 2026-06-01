package com.tico.mypawday.ui.main.view.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tico.mypawday.R
import com.tico.mypawday.ui.icons.MyPawDayIcons
import com.tico.mypawday.ui.main.view.model.CalendarDay
import com.tico.mypawday.ui.main.view.model.PetCondition
import com.tico.mypawday.ui.theme.MyPawDayTypography


private const val CELL_CONTENT_FILL = 0.85f

@Composable
fun CalendarDayCell(
    day: CalendarDay,
    isSelected: Boolean,
    isToday: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        if (isSelected && day.isCurrentMonth) {
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .background(
                        MaterialTheme.colorScheme.outlineVariant,
                        CircleShape,
                    ),
            )
        }

        when {
            day.petImageRes != null -> {
                Image(
                    painter = painterResource(day.petImageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(CELL_CONTENT_FILL)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }

            day.condition != null && day.hasHospital -> {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(conditionDrawable(day.condition)),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(CELL_CONTENT_FILL),
                        contentScale = ContentScale.Fit,
                    )
                    Icon(
                        imageVector = MyPawDayIcons.IcCalendarHospital,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(16.dp),
                        tint = Color.Unspecified,
                    )
                }
            }

            day.condition != null -> {
                Image(
                    painter = painterResource(conditionDrawable(day.condition)),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(CELL_CONTENT_FILL),
                    contentScale = ContentScale.Fit,
                )
            }

            day.hasHospital -> {
                Icon(
                    imageVector = MyPawDayIcons.IcCalendarHospital,
                    contentDescription = stringResource(R.string.content_hospital_indicator),
                    modifier = Modifier.fillMaxSize(CELL_CONTENT_FILL),
                    tint = Color.Unspecified,
                )
            }

            day.isCurrentMonth -> {
                Text(
                    text = "${day.date.dayOfMonth}",
                    style = MyPawDayTypography.robotoRegular14,
                    color = when {
                        isSelected && isToday -> MaterialTheme.colorScheme.onPrimary
                        isToday -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.onBackground
                    },
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

private fun conditionDrawable(condition: PetCondition): Int = when (condition) {
    PetCondition.GOOD -> R.drawable.ic_condition_good
    PetCondition.NORMAL -> R.drawable.ic_condition_normal
    PetCondition.BAD -> R.drawable.ic_condition_bad
}