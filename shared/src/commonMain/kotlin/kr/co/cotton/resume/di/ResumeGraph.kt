package kr.co.cotton.resume.di

import dev.zacsweers.metro.Binds
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph
import kr.co.cotton.resume.data.resume.ResumeService
import kr.co.cotton.resume.data.resume.ResumeServiceImpl
import kotlinx.serialization.json.Json

@DependencyGraph
interface ResumeGraph {
    val resumeService: ResumeService

    // Service bindings
    @Binds
    val ResumeServiceImpl.bindResumeService: ResumeService

    // JSON parser dependencies
    @Provides
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
    }
}
