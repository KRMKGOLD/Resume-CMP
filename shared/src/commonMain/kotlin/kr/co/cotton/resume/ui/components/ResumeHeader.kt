package kr.co.cotton.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Contact
import kr.co.cotton.resume.model.resume.Link
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun ResumeHeader(
    title: String,
    contacts: List<Contact>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(ResumeSpacing.profileTitle),
    ) {
        Text(
            text = title,
            style = ResumeTypography.h1,
            color = ResumeColors.gray900,
        )

        if (contacts.isNotEmpty()) {
            Column(verticalArrangement = Arrangement.spacedBy(ResumeSpacing.content)) {
                contacts.forEach { contact ->
                    ContactItem(contact = contact)
                }
            }
        }
    }
}

@Composable
private fun ContactItem(
    contact: Contact,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(ResumeSpacing.content),
    ) {
        contact.value?.let { value ->
            ContactValueRow(
                label = contact.label,
                value = value,
            )
        }

        contact.links.forEachIndexed { index, link ->
            ContactLinkRow(
                label = if (contact.value == null && index == 0) contact.label else null,
                link = link,
            )
        }
    }
}

@Composable
private fun ContactValueRow(
    label: String?,
    value: String,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        ContactLabel(label = label)

        Text(
            text = value,
            style = ResumeTypography.regular,
            color = ResumeColors.gray800,
            modifier = Modifier
                .weight(1f)
                .alignByBaseline(),
        )
    }
}

@Composable
private fun ContactLinkRow(
    label: String?,
    link: Link,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        ContactLabel(label = label)

        LinkText(
            link = link,
            modifier = Modifier.alignByBaseline(),
        )
    }
}

@Composable
private fun RowScope.ContactLabel(
    label: String?,
) {
    val contentLabelWidth = 80.dp

    if (label == null) {
        Spacer(modifier = Modifier.width(contentLabelWidth))
        return
    }

    Text(
        text = label,
        style = ResumeTypography.bold,
        color = ResumeColors.gray800,
        modifier = Modifier
            .width(contentLabelWidth)
            .alignByBaseline(),
    )
}
