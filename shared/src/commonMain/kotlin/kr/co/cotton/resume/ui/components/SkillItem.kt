package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Skill
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun SkillItem(
    skill: Skill,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = ResumeColors.gray50,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, ResumeColors.gray200),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = skill.category,
                style = ResumeTypography.bold,
                color = ResumeColors.gray900,
            )

            if (skill.items.isNotEmpty()) {
                Text(
                    text = skill.items.joinToString(separator = " · "),
                    style = ResumeTypography.regular,
                    color = ResumeColors.gray800,
                )
            }
        }
    }
}
