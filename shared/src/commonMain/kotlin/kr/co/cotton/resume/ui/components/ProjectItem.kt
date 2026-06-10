package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
            title = "프로젝트 설명",
            description = project.description,
        )

        BulletText(
            title = "기간",
            description = project.period.toPeriodLabel(separator = "~"),
        )

        if (project.responsibilities.isNotEmpty()) {
            BulletText(
                title = "업무 내용",
            )

            Column(
                modifier = Modifier.padding(start = ResumeSpacing.depth),
                verticalArrangement = Arrangement.spacedBy(ResumeSpacing.itemTitle),
            ) {
                project.responsibilities.forEach { responsibility ->
                    BulletText(text = responsibility)
                }
            }
        }

        if (project.references.isNotEmpty()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(ResumeSpacing.content),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                project.references.forEach { reference ->
                    LinkText(link = reference)
                }
            }
        }
    }
}
