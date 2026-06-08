package kr.co.cotton.resume

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform