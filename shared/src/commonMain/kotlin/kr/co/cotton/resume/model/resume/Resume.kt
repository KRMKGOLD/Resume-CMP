package kr.co.cotton.resume.model.resume

import kotlinx.serialization.Serializable

@Serializable
data class Resume(
    val title: String,
    val contacts: List<Contact> = emptyList(),
    val summary: List<String> = emptyList(),
    val skills: List<Skill> = emptyList(),
    val experience: List<Experience> = emptyList(),
    val projects: List<Project> = emptyList(),
)

@Serializable
data class Contact(
    val label: String,
    val value: String? = null,
    val links: List<Link> = emptyList(),
)

@Serializable
data class Link(
    val label: String,
    val url: String,
)

@Serializable
data class Skill(
    val category: String,
    val items: List<String> = emptyList(),
)

@Serializable
data class Experience(
    val company: String,
    val companyEn: String? = null,
    val role: String,
    val duration: String? = null,
    val period: Period,
    val note: String? = null,
    val highlights: List<String> = emptyList(),
)

@Serializable
data class Period(
    val start: String,
    val end: String? = null,
)

@Serializable
data class Project(
    val title: String,
    val description: String,
    val period: Period,
    val responsibilities: List<String> = emptyList(),
    val references: List<Link> = emptyList(),
)
