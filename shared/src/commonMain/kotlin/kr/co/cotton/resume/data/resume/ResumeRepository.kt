package kr.co.cotton.resume.data.resume

import org.jetbrains.compose.resources.ExperimentalResourceApi
import resume.shared.generated.resources.Res

class ResumeRepository {
    @OptIn(ExperimentalResourceApi::class)
    suspend fun getResume(): ResumeDto {
        val bytes = Res.readBytes("files/resume.json")
        return ResumeJsonParser.parse(bytes.decodeToString())
    }
}
