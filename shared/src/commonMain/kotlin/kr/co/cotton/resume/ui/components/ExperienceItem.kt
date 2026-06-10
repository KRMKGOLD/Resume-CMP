package kr.co.cotton.resume.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.cotton.resume.model.resume.Experience

@Composable
fun ExperienceItem(
    experience: Experience,
    modifier: Modifier = Modifier,
) {
    ResumeItem(
        title = experience.company,
        modifier = modifier,
    ) {
        BulletText(
            text = ResumeBullet.labeled(
                label = "Role",
                value = experience.role,
            ),
        )

        experience.companyEn?.let { companyEn ->
            BulletText(
                text = ResumeBullet.labeled(
                    label = "Company",
                    value = companyEn,
                ),
            )
        }

        BulletText(
            text = ResumeBullet.labeled(
                label = "Period",
                value = experience.period.toPeriodLabel(),
            ),
        )

        experience.duration?.let { duration ->
            BulletText(
                text = ResumeBullet.labeled(
                    label = "Duration",
                    value = duration,
                ),
            )
        }

        experience.note?.let { note ->
            BulletText(
                text = ResumeBullet.labeled(
                    label = "Note",
                    value = note,
                ),
            )
        }

        if (experience.highlights.isNotEmpty()) {
            BulletGroup(items = experience.highlights)
        }
    }
}
