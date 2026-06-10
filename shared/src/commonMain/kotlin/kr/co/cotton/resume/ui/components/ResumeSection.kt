package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun ResumeSection(
    title: String,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(ResumeSpacing.text),
    ) {
        Text(
            text = title,
            style = ResumeTypography.h2,
            color = ResumeColors.gray900,
        )

        content()
    }
}

@Composable
fun SummaryList(
    summary: List<String>,
    modifier: Modifier = Modifier,
) {
    BulletGroup(
        items = summary,
        modifier = modifier,
        spacing = ResumeSpacing.item,
    )
}
