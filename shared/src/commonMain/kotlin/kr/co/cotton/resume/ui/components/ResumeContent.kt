package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Link
import kr.co.cotton.resume.model.resume.Period
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

internal object ResumeSpacing {
    val area = 32.dp
    val depth = 24.dp
    val sectionTitle = 16.dp
    val itemTitle = 6.dp
    val content = 6.dp
}

internal object ResumeBullet {
    fun regular(text: String): AnnotatedString = buildAnnotatedString {
        withStyle(ResumeTypography.regular.toParagraphStyle()) {
            withStyle(ResumeTypography.regular.toSpanStyle()) {
                append(text)
            }
        }
    }

    fun labeled(
        label: String,
        value: String,
    ): AnnotatedString = buildAnnotatedString {
        withStyle(ResumeTypography.regular.toParagraphStyle()) {
            withStyle(ResumeTypography.bold.toSpanStyle()) {
                append(label)
            }

            withStyle(ResumeTypography.regular.toSpanStyle()) {
                append(": ")
                append(value)
            }
        }
    }

    fun label(label: String): AnnotatedString = buildAnnotatedString {
        withStyle(ResumeTypography.regular.toParagraphStyle()) {
            withStyle(ResumeTypography.bold.toSpanStyle()) {
                append(label)
                append(":")
            }
        }
    }

    fun emphasized(text: String): AnnotatedString = buildAnnotatedString {
        withStyle(ResumeTypography.regular.toParagraphStyle()) {
            withStyle(ResumeTypography.bold.toSpanStyle()) {
                append(text)
            }
        }
    }
}

@Composable
internal fun ResumeItem(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(ResumeSpacing.itemTitle),
    ) {
        Text(
            text = title,
            style = ResumeTypography.h3,
            color = ResumeColors.gray900,
        )

        content()
    }
}

@Composable
internal fun BulletText(
    text: AnnotatedString,
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
            color = ResumeColors.gray800,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
internal fun BulletGroup(
    items: List<String>,
    modifier: Modifier = Modifier,
    spacing: Dp = ResumeSpacing.itemTitle,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(spacing),
    ) {
        items.forEach { item ->
            BulletText(text = ResumeBullet.regular(item))
        }
    }
}

@Composable
internal fun LinkText(
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

internal fun Period.toPeriodLabel(separator: String = "-"): String {
    return end?.let { end -> "$start $separator $end" } ?: "$start $separator Present"
}
