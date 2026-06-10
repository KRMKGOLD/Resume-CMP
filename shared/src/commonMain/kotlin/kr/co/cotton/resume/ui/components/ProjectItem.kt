package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.co.cotton.resume.model.resume.Project

@Composable
fun ProjectItem(
    project: Project,
    modifier: Modifier = Modifier,
) {
    ResumeItem(
        title = project.title,
        modifier = modifier,
    ) {
        BulletText(
            text = ResumeBullet.labeled(
                label = "프로젝트 설명",
                value = project.description,
            ),
        )

        BulletText(
            text = ResumeBullet.labeled(
                label = "기간",
                value = project.period.toPeriodLabel(separator = "~"),
            ),
        )

        if (project.responsibilities.isNotEmpty()) {
            BulletText(
                text = ResumeBullet.label(label = "업무 내용"),
            )

            BulletGroup(items = project.responsibilities)
        }

        if (project.references.isNotEmpty()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(ResumeSpacing.text),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                project.references.forEach { reference ->
                    LinkText(link = reference)
                }
            }
        }
    }
}
