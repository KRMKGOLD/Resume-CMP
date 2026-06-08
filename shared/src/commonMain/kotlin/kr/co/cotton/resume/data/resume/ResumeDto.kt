package kr.co.cotton.resume.data.resume

import kotlinx.serialization.Serializable

@Serializable
data class ResumeDto(
    val title: String,
    val contacts: List<ContactDto> = emptyList(),
    val summary: List<String> = emptyList(),
    val skills: List<SkillDto> = emptyList(),
    val experience: List<ExperienceDto> = emptyList(),
    val projects: List<ProjectDto> = emptyList(),
)

@Serializable
data class ContactDto(
    val label: String,
    val value: String? = null,
    val links: List<LinkDto> = emptyList(),
)

@Serializable
data class LinkDto(
    val label: String,
    val url: String,
)

@Serializable
data class SkillDto(
    val category: String,
    val items: List<String> = emptyList(),
)

@Serializable
data class ExperienceDto(
    val company: String,
    val companyEn: String? = null,
    val role: String,
    val duration: String? = null,
    val period: PeriodDto,
    val note: String? = null,
    val highlights: List<String> = emptyList(),
)

@Serializable
data class PeriodDto(
    val start: String,
    val end: String? = null,
)

@Serializable
data class ProjectDto(
    val title: String,
    val description: String,
    val period: PeriodDto,
    val responsibilities: List<String> = emptyList(),
    val references: List<LinkDto> = emptyList(),
)
