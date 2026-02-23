package com.tico.mypawday.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp
import com.tico.mypawday.ui.theme.comfortingGreenYellow
import com.tico.mypawday.ui.theme.lightBackground
import com.tico.mypawday.ui.theme.lightGray40
import com.tico.mypawday.ui.theme.lightOnPrimaryContainer
import com.tico.mypawday.ui.theme.lightOnSurface
import com.tico.mypawday.ui.theme.lightOutline
import com.tico.mypawday.ui.theme.lightPrimary
import com.tico.mypawday.ui.theme.lightRed
import com.tico.mypawday.ui.theme.splashyBlue
import com.tico.mypawday.ui.theme.yellowShinyGold

object MyPawDayIcons {

    val IcAddCircle: ImageVector
        get() {
            if (_icAddCircle != null) return _icAddCircle!!
            _icAddCircle = ImageVector.Builder(
                name = "IcAddCircle",
                defaultWidth = 18.dp,
                defaultHeight = 18.dp,
                viewportWidth = 18f,
                viewportHeight = 18f
            ).addPath(
                pathData = addPathNodes("M9 1.5C4.86 1.5 1.5 4.86 1.5 9C1.5 13.14 4.86 16.5 9 16.5C13.14 16.5 16.5 13.14 16.5 9C16.5 4.86 13.14 1.5 9 1.5ZM12.75 9.75H9.75V12.75H8.25V9.75H5.25V8.25H8.25V5.25H9.75V8.25H12.75V9.75Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).build()
            return _icAddCircle!!
        }
    private var _icAddCircle: ImageVector? = null

    val IcAddPhotoAlternate: ImageVector
        get() {
            if (_icAddPhotoAlternate != null) return _icAddPhotoAlternate!!
            _icAddPhotoAlternate = ImageVector.Builder(
                name = "IcAddPhotoAlternate",
                defaultWidth = 18.dp,
                defaultHeight = 18.dp,
                viewportWidth = 18f,
                viewportHeight = 18f
            ).addPath(
                pathData = addPathNodes("M13.5 15H3V4.5H9.75V3H3C2.175 3 1.5 3.675 1.5 4.5V15C1.5 15.825 2.175 16.5 3 16.5H13.5C14.325 16.5 15 15.825 15 15V8.25H13.5V15ZM7.6575 12.6225L6.1875 10.8525L4.125 13.5H12.375L9.72 9.9675L7.6575 12.6225ZM15 3V0.75H13.5V3H11.25C11.2575 3.0075 11.25 4.5 11.25 4.5H13.5V6.7425C13.5075 6.75 15 6.7425 15 6.7425V4.5H17.25V3H15Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).build()
            return _icAddPhotoAlternate!!
        }
    private var _icAddPhotoAlternate: ImageVector? = null

    val IcToggleAdd: ImageVector
        get() {
            if (_icToggleAdd != null) return _icToggleAdd!!
            _icToggleAdd = ImageVector.Builder(
                name = "IcToggleAdd",
                defaultWidth = 40.dp,
                defaultHeight = 40.dp,
                viewportWidth = 40f,
                viewportHeight = 40f
            ).addPath(
                pathData = addPathNodes("M31.6666 21.6667H21.6666V31.6667H18.3333V21.6667H8.33325V18.3334H18.3333V8.33337H21.6666V18.3334H31.6666V21.6667Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).build()
            return _icToggleAdd!!
        }
    private var _icToggleAdd: ImageVector? = null

    val IcArrowDropDown: ImageVector
        get() {
            if (_icArrowDropDown != null) return _icArrowDropDown!!
            _icArrowDropDown = ImageVector.Builder(
                name = "IcArrowDropDown",
                defaultWidth = 19.dp,
                defaultHeight = 19.dp,
                viewportWidth = 19f,
                viewportHeight = 19f
            ).addPath(
                pathData = addPathNodes("M5.54175 7.91669L9.50008 11.875L13.4584 7.91669H5.54175Z"),
                fill = SolidColor(lightPrimary)
            ).build()
            return _icArrowDropDown!!
        }
    private var _icArrowDropDown: ImageVector? = null

    val IcCalendar: ImageVector
        get() {
            if (_icCalendar != null) return _icCalendar!!
            _icCalendar = ImageVector.Builder(
                name = "IcCalendar",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).addPath(
                pathData = addPathNodes("M15.8333 3.33332H15V1.66666H13.3333V3.33332H6.66667V1.66666H5V3.33332H4.16667C3.24167 3.33332 2.50833 4.08332 2.50833 4.99999L2.5 16.6667C2.5 17.5833 3.24167 18.3333 4.16667 18.3333H15.8333C16.75 18.3333 17.5 17.5833 17.5 16.6667V4.99999C17.5 4.08332 16.75 3.33332 15.8333 3.33332ZM15.8333 16.6667H4.16667V8.33332H15.8333V16.6667ZM15.8333 6.66666H4.16667V4.99999H15.8333V6.66666ZM7.5 11.6667H5.83333V9.99999H7.5V11.6667ZM10.8333 11.6667H9.16667V9.99999H10.8333V11.6667ZM14.1667 11.6667H12.5V9.99999H14.1667V11.6667ZM7.5 15H5.83333V13.3333H7.5V15ZM10.8333 15H9.16667V13.3333H10.8333V15ZM14.1667 15H12.5V13.3333H14.1667V15Z"),
                fill = SolidColor(lightOutline)
            ).build()
            return _icCalendar!!
        }
    private var _icCalendar: ImageVector? = null

    val IcCancel: ImageVector
        get() {
            if (_icCancel != null) return _icCancel!!
            _icCancel = ImageVector.Builder(
                name = "IcCancel",
                defaultWidth = 21.dp,
                defaultHeight = 21.dp,
                viewportWidth = 21f,
                viewportHeight = 21f
            ).addPath(
                pathData = addPathNodes("M10.5 1.75C5.66125 1.75 1.75 5.66125 1.75 10.5C1.75 15.3387 5.66125 19.25 10.5 19.25C15.3387 19.25 19.25 15.3387 19.25 10.5C19.25 5.66125 15.3387 1.75 10.5 1.75ZM14.875 13.6413L13.6413 14.875L10.5 11.7337L7.35875 14.875L6.125 13.6413L9.26625 10.5L6.125 7.35875L7.35875 6.125L10.5 9.26625L13.6413 6.125L14.875 7.35875L11.7337 10.5L14.875 13.6413Z"),
                fill = SolidColor(Color.White)
            ).build()
            return _icCancel!!
        }
    private var _icCancel: ImageVector? = null

    val IcCheck: ImageVector
        get() {
            if (_icCheck != null) return _icCheck!!
            _icCheck = ImageVector.Builder(
                name = "IcCheck",
                defaultWidth = 38.dp,
                defaultHeight = 38.dp,
                viewportWidth = 38f,
                viewportHeight = 38f
            ).addPath(
                pathData = addPathNodes("M26 14L17 24L12 20"),
                stroke = SolidColor(lightOnSurface),
                strokeLineWidth = 2.08696f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ).build()
            return _icCheck!!
        }
    private var _icCheck: ImageVector? = null

    val IcClock: ImageVector
        get() {
            if (_icClock != null) return _icClock!!
            _icClock = ImageVector.Builder(
                name = "IcClock",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).addPath(
                pathData = addPathNodes("M10.0001 1.66667C5.40758 1.66667 1.66675 5.4075 1.66675 10C1.66675 14.5925 5.40758 18.3333 10.0001 18.3333C14.5926 18.3333 18.3334 14.5925 18.3334 10C18.3334 5.4075 14.5926 1.66667 10.0001 1.66667ZM10.0001 3.33334C13.6918 3.33334 16.6667 6.30824 16.6667 10C16.6667 13.6918 13.6918 16.6667 10.0001 16.6667C6.30831 16.6667 3.33341 13.6918 3.33341 10C3.33341 6.30824 6.30831 3.33334 10.0001 3.33334ZM9.16675 5.00001V10.3451L12.7442 13.9225L13.9226 12.7441L10.8334 9.65495V5.00001H9.16675Z"),
                fill = SolidColor(lightOutline)
            ).build()
            return _icClock!!
        }
    private var _icClock: ImageVector? = null

    val IcToggleClose: ImageVector
        get() {
            if (_icToggleClose != null) return _icToggleClose!!
            _icToggleClose = ImageVector.Builder(
                name = "IcToggleClose",
                defaultWidth = 40.dp,
                defaultHeight = 40.dp,
                viewportWidth = 40f,
                viewportHeight = 40f
            ).addPath(
                pathData = addPathNodes("M31.6666 10.6833L29.3166 8.33331L19.9999 17.65L10.6833 8.33331L8.33325 10.6833L17.6499 20L8.33325 29.3166L10.6833 31.6666L19.9999 22.35L29.3166 31.6666L31.6666 29.3166L22.3499 20L31.6666 10.6833Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).build()
            return _icToggleClose!!
        }
    private var _icToggleClose: ImageVector? = null

    val IcDeleteCard: ImageVector
        get() {
            if (_icDeleteCard != null) return _icDeleteCard!!
            _icDeleteCard = ImageVector.Builder(
                name = "IcDeleteCard",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                group(translationY = 960f) {
                    addPath(
                        pathData = addPathNodes("m376 -300 104 -104 104 104 56 -56 -104 -104 104 -104 -56 -56 -104 104 -104 -104 -56 56 104 104 -104 104 56 56Zm-96 180q-33 0 -56.5 -23.5T200 -200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33 -23.5 56.5T680 -120H280Z"),
                        fill = SolidColor(lightBackground)
                    )
                }
            }.build()
            return _icDeleteCard!!
        }
    private var _icDeleteCard: ImageVector? = null

    val IcEdit: ImageVector
        get() {
            if (_icEdit != null) return _icEdit!!
            _icEdit = ImageVector.Builder(
                name = "IcEdit",
                defaultWidth = 38.dp,
                defaultHeight = 38.dp,
                viewportWidth = 38f,
                viewportHeight = 38f
            ).addPath(
                pathData = addPathNodes("M22.2617 14.2817L23.7183 15.7383L9.37333 30.0833H7.91667V28.6267L22.2617 14.2817ZM27.9617 4.75C27.5658 4.75 27.1542 4.90833 26.8533 5.20917L23.9558 8.10667L29.8933 14.0442L32.7908 11.1467C33.4083 10.5292 33.4083 9.53167 32.7908 8.91417L29.0858 5.20917C28.7692 4.8925 28.3733 4.75 27.9617 4.75ZM22.2617 9.80083L4.75 27.3125V33.25H10.6875L28.1992 15.7383L22.2617 9.80083Z"),
                fill = SolidColor(lightOnSurface)
            ).build()
            return _icEdit!!
        }
    private var _icEdit: ImageVector? = null

    val IcConditionBadCircle: ImageVector
        get() {
            if (_icConditionBadCircle != null) return _icConditionBadCircle!!
            _icConditionBadCircle = ImageVector.Builder(
                name = "IcConditionBadCircle",
                defaultWidth = 8.dp,
                defaultHeight = 8.dp,
                viewportWidth = 8f,
                viewportHeight = 8f
            ).addPath(
                pathData = addPathNodes("M0 4a4 4 0 1 0 8 0a4 4 0 1 0 -8 0Z"),
                fill = SolidColor(lightRed)
            ).build()
            return _icConditionBadCircle!!
        }
    private var _icConditionBadCircle: ImageVector? = null

    val IcConditionGoodCircle: ImageVector
        get() {
            if (_icConditionGoodCircle != null) return _icConditionGoodCircle!!
            _icConditionGoodCircle = ImageVector.Builder(
                name = "IcConditionGoodCircle",
                defaultWidth = 8.dp,
                defaultHeight = 8.dp,
                viewportWidth = 8f,
                viewportHeight = 8f
            ).addPath(
                pathData = addPathNodes("M0 4a4 4 0 1 0 8 0a4 4 0 1 0 -8 0Z"),
                fill = SolidColor(comfortingGreenYellow)
            ).build()
            return _icConditionGoodCircle!!
        }
    private var _icConditionGoodCircle: ImageVector? = null

    val IcConditionNormalCircle: ImageVector
        get() {
            if (_icConditionNormalCircle != null) return _icConditionNormalCircle!!
            _icConditionNormalCircle = ImageVector.Builder(
                name = "IcConditionNormalCircle",
                defaultWidth = 8.dp,
                defaultHeight = 8.dp,
                viewportWidth = 8f,
                viewportHeight = 8f
            ).addPath(
                pathData = addPathNodes("M0 4a4 4 0 1 0 8 0a4 4 0 1 0 -8 0Z"),
                fill = SolidColor(yellowShinyGold)
            ).build()
            return _icConditionNormalCircle!!
        }
    private var _icConditionNormalCircle: ImageVector? = null

    val IcCalendarHospital: ImageVector
        get() {
            if (_icCalendarHospital != null) return _icCalendarHospital!!
            _icCalendarHospital = ImageVector.Builder(
                name = "IcCalendarHospital",
                defaultWidth = 40.dp,
                defaultHeight = 40.dp,
                viewportWidth = 40f,
                viewportHeight = 40f
            ).addPath(
                pathData = addPathNodes("M0.5 20a19.5 19.5 0 1 0 39 0a19.5 19.5 0 1 0 -39 0Z"),
                fill = SolidColor(Color.White),
                stroke = SolidColor(lightOnSurface),
                strokeLineWidth = 1f
            ).addPath(
                pathData = addPathNodes("M22.875 7C23.9796 7 24.875 7.89543 24.875 9V15.125H31C32.1046 15.125 33 16.0204 33 17.125V22.875C33 23.9796 32.1046 24.875 31 24.875H24.875V31C24.875 32.1046 23.9796 33 22.875 33H17.125C16.0204 33 15.125 32.1046 15.125 31V24.875H9C7.89543 24.875 7 23.9796 7 22.875V17.125C7 16.0204 7.89543 15.125 9 15.125H15.125V9C15.125 7.89543 16.0204 7 17.125 7H22.875Z"),
                fill = SolidColor(splashyBlue),
                stroke = SolidColor(lightOnSurface),
                strokeLineWidth = 1f
            ).build()
            return _icCalendarHospital!!
        }
    private var _icCalendarHospital: ImageVector? = null

    val IcKeyboardArrowLeft: ImageVector
        get() {
            if (_icKeyboardArrowLeft != null) return _icKeyboardArrowLeft!!
            _icKeyboardArrowLeft = ImageVector.Builder(
                name = "IcKeyboardArrowLeft",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).addPath(
                pathData = addPathNodes("M15.41 16.59L10.83 12L15.41 7.41L14 6L8 12L14 18L15.41 16.59Z"),
                fill = SolidColor(lightOnSurface)
            ).build()
            return _icKeyboardArrowLeft!!
        }
    private var _icKeyboardArrowLeft: ImageVector? = null

    val IcKeyboardArrowRight: ImageVector
        get() {
            if (_icKeyboardArrowRight != null) return _icKeyboardArrowRight!!
            _icKeyboardArrowRight = ImageVector.Builder(
                name = "IcKeyboardArrowRight",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).addPath(
                pathData = addPathNodes("M8.59009 16.59L13.1701 12L8.59009 7.41L10.0001 6L16.0001 12L10.0001 18L8.59009 16.59Z"),
                fill = SolidColor(lightOnSurface)
            ).build()
            return _icKeyboardArrowRight!!
        }
    private var _icKeyboardArrowRight: ImageVector? = null

    val IcMoveRightPage: ImageVector
        get() {
            if (_icMoveRightPage != null) return _icMoveRightPage!!
            _icMoveRightPage = ImageVector.Builder(
                name = "IcMoveRightPage",
                defaultWidth = 34.dp,
                defaultHeight = 34.dp,
                viewportWidth = 34f,
                viewportHeight = 34f
            ).addPath(
                pathData = addPathNodes("M12.1692 23.5025L18.6575 17L12.1692 10.4975L14.1667 8.5L22.6667 17L14.1667 25.5L12.1692 23.5025Z"),
                fill = SolidColor(lightGray40)
            ).build()
            return _icMoveRightPage!!
        }
    private var _icMoveRightPage: ImageVector? = null

    val IcAddHospital: ImageVector
        get() {
            if (_icAddHospital != null) return _icAddHospital!!
            _icAddHospital = ImageVector.Builder(
                name = "IcAddHospital",
                defaultWidth = 34.dp,
                defaultHeight = 34.dp,
                viewportWidth = 34f,
                viewportHeight = 34f
            ).addPath(
                pathData = addPathNodes("M26.9167 4.25H7.08333C5.525 4.25 4.26417 5.525 4.26417 7.08333L4.25 26.9167C4.25 28.475 5.525 29.75 7.08333 29.75H26.9167C28.475 29.75 29.75 28.475 29.75 26.9167V7.08333C29.75 5.525 28.475 4.25 26.9167 4.25ZM26.9167 26.9167H7.08333V7.08333H26.9167V26.9167ZM14.875 24.0833H19.125V19.125H24.0833V14.875H19.125V9.91667H14.875V14.875H9.91667V19.125H14.875V24.0833Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).build()
            return _icAddHospital!!
        }
    private var _icAddHospital: ImageVector? = null

    val IcAddWalk: ImageVector
        get() {
            if (_icAddWalk != null) return _icAddWalk!!
            _icAddWalk = ImageVector.Builder(
                name = "IcAddWalk",
                defaultWidth = 34.dp,
                defaultHeight = 34.dp,
                viewportWidth = 34f,
                viewportHeight = 34f
            ).addPath(
                pathData = addPathNodes("M6.37492 17C8.33093 17 9.91659 15.4143 9.91659 13.4583C9.91659 11.5023 8.33093 9.91663 6.37492 9.91663C4.41891 9.91663 2.83325 11.5023 2.83325 13.4583C2.83325 15.4143 4.41891 17 6.37492 17Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).addPath(
                pathData = addPathNodes("M12.7499 11.3333C14.7059 11.3333 16.2916 9.74768 16.2916 7.79167C16.2916 5.83566 14.7059 4.25 12.7499 4.25C10.7939 4.25 9.20825 5.83566 9.20825 7.79167C9.20825 9.74768 10.7939 11.3333 12.7499 11.3333Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).addPath(
                pathData = addPathNodes("M21.2499 11.3333C23.2059 11.3333 24.7916 9.74768 24.7916 7.79167C24.7916 5.83566 23.2059 4.25 21.2499 4.25C19.2939 4.25 17.7083 5.83566 17.7083 7.79167C17.7083 9.74768 19.2939 11.3333 21.2499 11.3333Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).addPath(
                pathData = addPathNodes("M27.6249 17C29.5809 17 31.1666 15.4143 31.1666 13.4583C31.1666 11.5023 29.5809 9.91663 27.6249 9.91663C25.6689 9.91663 24.0833 11.5023 24.0833 13.4583C24.0833 15.4143 25.6689 17 27.6249 17Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).addPath(
                pathData = addPathNodes("M24.565 21.0517C23.3325 19.6067 22.2983 18.3742 21.0517 16.9292C20.4 16.1642 19.5642 15.3992 18.5725 15.0592C18.4167 15.0025 18.2608 14.96 18.105 14.9317C17.7508 14.875 17.3683 14.875 17 14.875C16.6317 14.875 16.2492 14.875 15.8808 14.9458C15.725 14.9742 15.5692 15.0167 15.4133 15.0733C14.4217 15.4133 13.6 16.1783 12.9342 16.9433C11.7017 18.3883 10.6675 19.6208 9.42083 21.0658C7.565 22.9217 5.28417 24.9758 5.70917 27.8517C6.12 29.2967 7.15417 30.7275 9.01 31.1383C10.0442 31.3508 13.345 30.515 16.8583 30.515H17.1133C20.6267 30.515 23.9275 31.3367 24.9617 31.1383C26.8175 30.7275 27.8517 29.2825 28.2625 27.8517C28.7017 24.9617 26.4208 22.9075 24.565 21.0517Z"),
                fill = SolidColor(lightOnPrimaryContainer)
            ).build()
            return _icAddWalk!!
        }
    private var _icAddWalk: ImageVector? = null
}