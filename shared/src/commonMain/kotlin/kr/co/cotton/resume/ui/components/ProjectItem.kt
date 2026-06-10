package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Project
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun ProjectItem(
    project: Project,
    modifier: Modifier = Modifier,
) {
    ResumeBlock(modifier = modifier) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = project.title,
                    style = ResumeTypography.h3,
                    color = ResumeColors.gray900,
                    modifier = Modifier.weight(1f),
                )

                Spacer(modifier = Modifier.width(16.dp))
                PeriodText(period = project.period)
            }

            Text(
                text = project.description,
                style = ResumeTypography.regular,
                color = ResumeColors.gray800,
            )

            if (project.responsibilities.isNotEmpty()) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    project.responsibilities.forEach { responsibility ->
                        BulletText(text = responsibility)
                    }
                }
            }

            if (project.references.isNotEmpty()) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    project.references.forEach { reference ->
                        LinkText(link = reference)
                    }
                }
            }
        }
    }
}
