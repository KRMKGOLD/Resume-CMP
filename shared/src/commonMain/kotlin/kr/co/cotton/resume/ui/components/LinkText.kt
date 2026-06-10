package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import kr.co.cotton.resume.model.resume.Link
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun LinkText(
    link: Link,
    modifier: Modifier = Modifier,
) {
    val uriHandler = LocalUriHandler.current

    Text(
        text = link.label,
        style = ResumeTypography.bold,
        color = ResumeColors.highlight,
        modifier = modifier.clickable {
            uriHandler.openUri(link.url)
        },
    )
}
