package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Contact
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun ContactItem(
    contact: Contact,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = contact.label,
            style = ResumeTypography.bold,
            color = ResumeColors.gray800,
            modifier = Modifier.width(72.dp),
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            contact.value?.let { value ->
                Text(
                    text = value,
                    style = ResumeTypography.regular,
                    color = ResumeColors.gray800,
                )
            }

            contact.links.forEach { link ->
                LinkText(link = link)
            }
        }
    }
}
