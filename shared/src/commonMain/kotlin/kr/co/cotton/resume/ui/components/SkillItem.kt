package kr.co.cotton.resume.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.cotton.resume.model.resume.Skill

@Composable
fun SkillItem(
    skill: Skill,
    modifier: Modifier = Modifier,
) {
    BulletText(
        text = if (skill.items.isEmpty()) {
            ResumeBullet.emphasized(text = skill.category)
        } else {
            ResumeBullet.labeled(
                label = skill.category,
                value = skill.items.joinToString(separator = " · "),
            )
        },
        modifier = modifier,
    )
}
