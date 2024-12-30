package com.nhiroaki.ratingbar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
