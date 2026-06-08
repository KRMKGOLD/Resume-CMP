package kr.co.cotton.resume.data.resume

import kr.co.cotton.resume.model.resume.Resume

interface ResumeService {
    suspend fun getResume(): Resume
}
