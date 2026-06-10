package kr.co.cotton.resume.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.co.cotton.resume.model.resume.Resume
import kr.co.cotton.resume.ui.components.ExperienceItem
import kr.co.cotton.resume.ui.components.ProjectItem
import kr.co.cotton.resume.ui.components.ResumeHeader
import kr.co.cotton.resume.ui.components.ResumeSection
import kr.co.cotton.resume.ui.components.SkillItem
import kr.co.cotton.resume.ui.components.SummaryList
import kr.co.cotton.resume.ui.theme.ResumeColors

@Composable
fun ResumeScreen(
    resume: Resume,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ResumeColors.white)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 920.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(40.dp),
        ) {
            ResumeHeader(
                title = resume.title,
                contacts = resume.contacts,
            )

            if (resume.summary.isNotEmpty()) {
                ResumeSection(title = "Summary") {
                    SummaryList(summary = resume.summary)
                }
            }

            if (resume.skills.isNotEmpty()) {
                ResumeSection(title = "Skills") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        resume.skills.forEach { skill ->
                            SkillItem(skill = skill)
                        }
                    }
                }
            }

            if (resume.experience.isNotEmpty()) {
                ResumeSection(title = "Experience") {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        resume.experience.forEach { experience ->
                            ExperienceItem(experience = experience)
                        }
                    }
                }
            }

            if (resume.projects.isNotEmpty()) {
                ResumeSection(title = "Projects") {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        resume.projects.forEach { project ->
                            ProjectItem(project = project)
                        }
                    }
                }
            }
        }
    }
}
