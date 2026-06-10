package kr.co.cotton.resume.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.cotton.resume.model.resume.Period
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun PeriodText(
    period: Period,
    modifier: Modifier = Modifier,
) {
    Text(
        text = period.end?.let { end -> "${period.start} - $end" } ?: "${period.start} - Present",
        style = ResumeTypography.regular,
        color = ResumeColors.gray600,
        modifier = modifier,
    )
}
