package kr.co.cotton.resume.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import kr.co.cotton.resume.model.resume.Experience
import kr.co.cotton.resume.model.resume.Period
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun ExperienceItem(
    experience: Experience,
    modifier: Modifier = Modifier,
) {
    ResumeItem(
        title = experience.company,
        modifier = modifier,
    ) {
        Text(
            text = experience.roleWithMeta(),
            color = ResumeColors.gray800,
        )

        if (experience.highlights.isNotEmpty()) {
            BulletGroup(items = experience.highlights)
        }
    }
}

private fun Experience.roleWithMeta(): AnnotatedString = buildAnnotatedString {
    withStyle(ResumeTypography.regular.toParagraphStyle()) {
        withStyle(ResumeTypography.bold.toSpanStyle()) {
            append(role)
        }

        withStyle(ResumeTypography.regular.toSpanStyle()) {
            append(" (")
            append(experienceMeta(period = period, duration = duration, note = note))
            append(")")
        }
    }
}

private fun experienceMeta(
    period: Period,
    duration: String?,
    note: String?,
): String {
    val meta = buildList {
        add(period.toPeriodLabel())
        duration?.let(::add)
        note?.let(::add)
    }.joinToString(separator = ", ")

    return meta
}
