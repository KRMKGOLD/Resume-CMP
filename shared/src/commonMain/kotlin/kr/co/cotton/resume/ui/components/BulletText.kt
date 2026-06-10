package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
internal fun BulletText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        Spacer(
            modifier = Modifier
                .padding(top = 10.dp)
                .size(4.dp)
                .clip(CircleShape)
                .background(ResumeColors.highlight),
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = text,
            style = ResumeTypography.regular,
            color = ResumeColors.gray800,
            modifier = Modifier.weight(1f),
        )
    }
}
