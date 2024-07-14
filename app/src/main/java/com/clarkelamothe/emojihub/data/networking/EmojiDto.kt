package com.clarkelamothe.emojihub.data.networking

import kotlinx.serialization.Serializable

@Serializable
data class EmojiDto(
    val name: String,
    val category: String,
    val group: String,
    val unicode: List<String>
)
