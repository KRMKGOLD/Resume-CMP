package kr.co.cotton.resume.data.remote.resume

import dev.zacsweers.metro.Inject
import kr.co.cotton.resume.model.resume.Resume
import kotlinx.serialization.json.Json

@Inject
class ResumeJsonParser(
    private val json: Json,
) {
    fun parse(value: String): Resume = json.decodeFromString<Resume>(value)
}
