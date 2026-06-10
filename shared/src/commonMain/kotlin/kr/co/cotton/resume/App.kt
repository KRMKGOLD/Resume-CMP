package kr.co.cotton.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.zacsweers.metro.createGraph
import kr.co.cotton.resume.data.resume.ResumeService
import kr.co.cotton.resume.di.ResumeGraph
import kr.co.cotton.resume.model.resume.Resume
import kr.co.cotton.resume.ui.ResumeScreen
import kr.co.cotton.resume.ui.theme.ResumeColors
import kr.co.cotton.resume.ui.theme.ResumeTypography

@Composable
fun App() {
    val resumeService = rememberResumeService()
    var state by remember { mutableStateOf<ResumeLoadState>(ResumeLoadState.Loading) }

    LaunchedEffect(resumeService) {
        state = runCatching { resumeService.getResume() }
            .fold(
                onSuccess = ResumeLoadState::Success,
                onFailure = ResumeLoadState::Error,
            )
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .background(ResumeColors.white)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            when (val currentState = state) {
                ResumeLoadState.Loading -> ResumeStatusMessage(text = "Loading resume...")
                is ResumeLoadState.Error -> ResumeStatusMessage(
                    text = currentState.throwable.message ?: "Failed to load resume.",
                )

                is ResumeLoadState.Success -> ResumeScreen(resume = currentState.resume)
            }
        }
    }
}

@Composable
private fun rememberResumeService(): ResumeService {
    return remember { createGraph<ResumeGraph>().resumeService }
}

@Composable
private fun ResumeStatusMessage(
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = text,
            style = ResumeTypography.regular,
            color = ResumeColors.gray600,
        )
    }
}

private sealed interface ResumeLoadState {
    data object Loading : ResumeLoadState
    data class Success(val resume: Resume) : ResumeLoadState
    data class Error(val throwable: Throwable) : ResumeLoadState
}
