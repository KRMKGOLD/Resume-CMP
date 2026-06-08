package kr.co.cotton.resume.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object ResumeTypography {

    val h1 = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 43.sp,
        letterSpacing = (-0.5).sp,
    )

    val h2 = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 35.sp,
        letterSpacing = 0.sp,
    )

    val h3 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 29.sp,
        letterSpacing = 0.sp,
    )

    val regular = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
    )

    val bold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
    )
}
