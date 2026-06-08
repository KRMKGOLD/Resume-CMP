package kr.co.cotton.resume.data.resume

import dev.zacsweers.metro.Inject
import kr.co.cotton.resume.data.remote.resume.ResumeJsonParser
import kr.co.cotton.resume.model.resume.Resume
import org.jetbrains.compose.resources.ExperimentalResourceApi
import resume.shared.generated.resources.Res

@Inject
class ResumeServiceImpl(
    private val parser: ResumeJsonParser,
) : ResumeService {
    @OptIn(ExperimentalResourceApi::class)
    override suspend fun getResume(): Resume {
        val bytes = Res.readBytes("files/resume.json")
        return parser.parse(bytes.decodeToString())
    }
}
