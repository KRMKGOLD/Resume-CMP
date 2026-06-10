package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Experience
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun ExperienceItem(
    experience: Experience,
    modifier: Modifier = Modifier,
) {
    ResumeBlock(modifier = modifier) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = experience.company,
                style = ResumeTypography.h3,
                color = ResumeColors.gray900,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = experience.role,
                        style = ResumeTypography.bold,
                        color = ResumeColors.gray800,
                    )

                    experience.companyEn?.let { companyEn ->
                        Text(
                            text = companyEn,
                            style = ResumeTypography.regular,
                            color = ResumeColors.gray600,
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(horizontalAlignment = Alignment.End) {
                    PeriodText(period = experience.period)

                    experience.duration?.let { duration ->
                        Text(
                            text = duration,
                            style = ResumeTypography.bold,
                            color = ResumeColors.highlight,
                        )
                    }
                }
            }

            experience.note?.let { note ->
                Text(
                    text = note,
                    style = ResumeTypography.regular,
                    color = ResumeColors.gray600,
                )
            }

            if (experience.highlights.isNotEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    experience.highlights.forEach { highlight ->
                        BulletText(text = highlight)
                    }
                }
            }
        }
    }
}
