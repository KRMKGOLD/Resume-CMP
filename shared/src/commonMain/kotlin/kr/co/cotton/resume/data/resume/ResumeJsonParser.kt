package kr.co.cotton.resume.data.resume

import kotlinx.serialization.json.Json

object ResumeJsonParser {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun parse(value: String): ResumeDto = json.decodeFromString<ResumeDto>(value)
}
