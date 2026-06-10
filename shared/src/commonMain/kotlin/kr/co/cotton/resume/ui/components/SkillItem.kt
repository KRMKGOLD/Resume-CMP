package kr.co.cotton.resume.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.cotton.resume.model.resume.Skill

@Composable
fun SkillItem(
    skill: Skill,
    modifier: Modifier = Modifier,
) {
    if (skill.items.isEmpty()) {
        BulletText(
            title = skill.category,
            modifier = modifier,
        )
        return
    }

    BulletText(
        title = skill.category,
        description = skill.items.joinToString(separator = ", "),
        modifier = modifier,
    )
}
